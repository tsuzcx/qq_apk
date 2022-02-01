package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;

public class ModRemarkRoomNameUI
  extends MMActivity
  implements c.a
{
  private MMClearEditText jbH;
  private TextView jbI;
  private Button jbJ;
  private TextView jbK;
  private ScrollView jbL;
  private InputPanelLinearLayout jbM;
  private String jbN;
  private String jbO;
  private String roomId;
  private int scene;
  private TextView titleView;
  
  private void Kz(String paramString)
  {
    AppMethodBeat.i(192572);
    if (Util.isNullOrNil(paramString))
    {
      this.jbK.setVisibility(8);
      AppMethodBeat.o(192572);
      return;
    }
    this.jbK.setVisibility(0);
    this.jbK.setText(paramString);
    AppMethodBeat.o(192572);
  }
  
  public int getLayoutId()
  {
    return a.f.jei;
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(192565);
    Log.i("MicroMsg.RemarkRoomNameUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jbJ.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(a.c.Edge_2A);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(a.c.Edge_2A);
      this.jbJ.setLayoutParams(localLayoutParams);
      this.jbM.setPadding(this.jbM.getPaddingLeft(), this.jbM.getPaddingTop(), this.jbM.getPaddingRight(), paramInt);
      paramInt = this.jbL.getHeight();
      this.jbM.requestLayout();
      this.jbM.post(new ModRemarkRoomNameUI.5(this, paramInt));
      AppMethodBeat.o(192565);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jbJ.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(a.c.Edge_12A);
    localLayoutParams.topMargin = 0;
    this.jbJ.setLayoutParams(localLayoutParams);
    this.jbM.setPadding(this.jbM.getPaddingLeft(), this.jbM.getPaddingTop(), this.jbM.getPaddingRight(), 0);
    this.jbL.scrollBy(0, 0);
    AppMethodBeat.o(192565);
  }
  
  public void initView()
  {
    AppMethodBeat.i(12668);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.b.white));
    this.jbL = ((ScrollView)findViewById(a.e.scroll_view));
    this.jbM = ((InputPanelLinearLayout)findViewById(a.e.input_container));
    this.jbM.setExternalListener(this);
    this.jbH = ((MMClearEditText)findViewById(a.e.jcX));
    this.titleView = ((TextView)findViewById(a.e.jcZ));
    this.jbI = ((TextView)findViewById(a.e.jcY));
    this.jbJ = ((Button)findViewById(a.e.next_btn));
    this.jbK = ((TextView)findViewById(a.e.error_tip));
    Object localObject2 = (ImageView)findViewById(a.e.jcp);
    Object localObject3 = findViewById(a.e.jcw);
    this.scene = getIntent().getIntExtra("Key_Scenen", 0);
    this.roomId = getIntent().getStringExtra("Key_Room_Id");
    Log.i("MicroMsg.RemarkRoomNameUI", "scene %d, roomId %s", new Object[] { Integer.valueOf(this.scene), this.roomId });
    if (Util.isNullOrNil(this.roomId)) {
      finish();
    }
    Object localObject1 = ((n)h.ae(n.class)).bbL().RG(this.roomId);
    if ((int)((d)localObject1).jxt > 0) {
      com.tencent.mm.ui.h.a.a.c((ImageView)localObject2, ((ax)localObject1).field_username);
    }
    localObject2 = l.c(this, Util.nullAsNil(((ax)localObject1).field_nickname));
    localObject1 = l.c(this, Util.nullAsNil(((ax)localObject1).field_conRemark));
    Log.i("MicroMsg.RemarkRoomNameUI", "roomName %s, remarkName %s", new Object[] { localObject2, localObject1 });
    switch (this.scene)
    {
    default: 
      Log.w("MicroMsg.RemarkRoomNameUI", "unknown scene %d, finish()", new Object[] { Integer.valueOf(this.scene) });
      finish();
    case 1: 
    case 3: 
      for (;;)
      {
        this.jbH.setSelection(this.jbH.getText().length());
        this.jbH.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(190059);
            ModRemarkRoomNameUI.c(ModRemarkRoomNameUI.this).setEnabled(ModRemarkRoomNameUI.b(ModRemarkRoomNameUI.this));
            AppMethodBeat.o(190059);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(190055);
            if (paramAnonymousCharSequence.length() > 0)
            {
              ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(null);
              AppMethodBeat.o(190055);
              return;
            }
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(TextUtils.TruncateAt.END);
            AppMethodBeat.o(190055);
          }
        });
        c.i(this.jbH).axx(32).Hh(false).a(null);
        this.jbH.requestFocus();
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(12665);
            ModRemarkRoomNameUI.this.finish();
            AppMethodBeat.o(12665);
            return true;
          }
        });
        this.jbJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(190759);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            ModRemarkRoomNameUI.d(ModRemarkRoomNameUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(190759);
          }
        });
        AppMethodBeat.o(12668);
        return;
        this.titleView.setText(a.i.jfJ);
        this.jbI.setText(a.i.jfx);
        this.jbH.setText((CharSequence)localObject2);
        if (Util.isNullOrNil((CharSequence)localObject2)) {
          this.jbH.setHint(getString(a.i.eRg));
        }
        this.jbO = getString(a.i.jfQ);
        this.jbN = getString(a.i.eQM);
        continue;
        this.titleView.setText(a.i.eRl);
        this.jbI.setText(a.i.jfv);
        localObject3 = this.jbH;
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.roomId);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = ((ah)localObject2).field_selfDisplayName;
        }
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = z.bdb();
        }
        ((MMClearEditText)localObject3).setText(l.c(this, l.c(this, (CharSequence)localObject2)));
        this.jbO = getString(a.i.eQL);
        this.jbN = getString(a.i.jfP);
      }
    }
    this.titleView.setText(a.i.jgt);
    this.jbI.setText(a.i.jfy);
    this.jbH.setText((CharSequence)localObject1);
    this.jbH.setHint(a.i.jgt);
    if (Util.isNullOrNil((CharSequence)localObject2)) {}
    for (localObject1 = getString(a.i.eRg);; localObject1 = localObject2)
    {
      ((View)localObject3).setVisibility(0);
      ((TextView)findViewById(a.e.jcx)).setText(l.c(this, getString(a.i.jfw, new Object[] { localObject1 })));
      localObject1 = (TextView)findViewById(a.e.jcy);
      if (!Util.isNullOrNil((CharSequence)localObject2)) {
        ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(193949);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setText(this.jbP);
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setSelection(ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).getText().length());
            this.jbQ.setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(193949);
          }
        });
      }
      for (;;)
      {
        this.jbO = getString(a.i.settings_modify_remark_invalid_more);
        break;
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12667);
    super.onCreate(paramBundle);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12667);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12670);
    super.onDestroy();
    AppMethodBeat.o(12670);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12669);
    super.onPause();
    AppMethodBeat.o(12669);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI
 * JD-Core Version:    0.7.0.1
 */