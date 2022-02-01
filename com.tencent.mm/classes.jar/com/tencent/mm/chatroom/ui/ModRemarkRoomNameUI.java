package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.roomsdk.model.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;

public class ModRemarkRoomNameUI
  extends MMActivity
  implements c.a
{
  private MMClearEditText lDH;
  private TextView lDI;
  private Button lDJ;
  private TextView lDK;
  private ScrollView lDL;
  private InputPanelLinearLayout lDM;
  private String lDN;
  private String lDO;
  private String roomId;
  private int scene;
  private TextView titleView;
  
  private void Df(String paramString)
  {
    AppMethodBeat.i(241633);
    if (Util.isNullOrNil(paramString))
    {
      this.lDK.setVisibility(8);
      AppMethodBeat.o(241633);
      return;
    }
    this.lDK.setVisibility(0);
    this.lDK.setText(paramString);
    AppMethodBeat.o(241633);
  }
  
  public int getLayoutId()
  {
    return a.f.lGs;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12668);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.b.white));
    this.lDL = ((ScrollView)findViewById(a.e.scroll_view));
    this.lDM = ((InputPanelLinearLayout)findViewById(a.e.input_container));
    this.lDM.setExternalListener(this);
    this.lDH = ((MMClearEditText)findViewById(a.e.lFf));
    this.titleView = ((TextView)findViewById(a.e.lFh));
    this.lDI = ((TextView)findViewById(a.e.lFg));
    this.lDJ = ((Button)findViewById(a.e.next_btn));
    this.lDK = ((TextView)findViewById(a.e.error_tip));
    Object localObject2 = (ImageView)findViewById(a.e.lEp);
    Object localObject3 = findViewById(a.e.lEw);
    this.scene = getIntent().getIntExtra("Key_Scenen", 0);
    this.roomId = getIntent().getStringExtra("Key_Room_Id");
    Log.i("MicroMsg.RemarkRoomNameUI", "scene %d, roomId %s", new Object[] { Integer.valueOf(this.scene), this.roomId });
    if (Util.isNullOrNil(this.roomId)) {
      finish();
    }
    Object localObject1 = ((n)h.ax(n.class)).bzA().JE(this.roomId);
    if ((int)((d)localObject1).maN > 0) {
      com.tencent.mm.ui.i.a.a.g((ImageView)localObject2, ((az)localObject1).field_username);
    }
    localObject2 = p.b(this, Util.nullAsNil(((az)localObject1).field_nickname));
    localObject1 = p.b(this, Util.nullAsNil(((az)localObject1).field_conRemark));
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
        this.lDH.setSelection(this.lDH.getText().length());
        this.lDH.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(241647);
            ModRemarkRoomNameUI.c(ModRemarkRoomNameUI.this).setEnabled(ModRemarkRoomNameUI.b(ModRemarkRoomNameUI.this));
            AppMethodBeat.o(241647);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(241639);
            if (paramAnonymousCharSequence.length() > 0)
            {
              ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(null);
              AppMethodBeat.o(241639);
              return;
            }
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(TextUtils.TruncateAt.END);
            AppMethodBeat.o(241639);
          }
        });
        c.i(this.lDH).aEg(32).Nc(false).a(null);
        this.lDH.requestFocus();
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
        this.lDJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(241653);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            ModRemarkRoomNameUI.d(ModRemarkRoomNameUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241653);
          }
        });
        AppMethodBeat.o(12668);
        return;
        this.titleView.setText(a.i.lHV);
        this.lDI.setText(a.i.lHI);
        this.lDH.setText((CharSequence)localObject2);
        if (Util.isNullOrNil((CharSequence)localObject2)) {
          this.lDH.setHint(getString(a.i.gTM));
        }
        this.lDO = getString(a.i.lIc);
        this.lDN = getString(a.i.gTs);
        continue;
        this.titleView.setText(a.i.gTR);
        this.lDI.setText(a.i.lHG);
        localObject3 = this.lDH;
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.roomId);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = ((aj)localObject2).field_selfDisplayName;
        }
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = z.bAO();
        }
        ((MMClearEditText)localObject3).setText(p.b(this, p.b(this, (CharSequence)localObject2)));
        this.lDO = getString(a.i.gTr);
        this.lDN = getString(a.i.lIb);
      }
    }
    this.titleView.setText(a.i.lIG);
    this.lDI.setText(a.i.lHJ);
    this.lDH.setText((CharSequence)localObject1);
    this.lDH.setHint(a.i.lIG);
    if (Util.isNullOrNil((CharSequence)localObject2)) {}
    for (localObject1 = getString(a.i.gTM);; localObject1 = localObject2)
    {
      ((View)localObject3).setVisibility(0);
      ((TextView)findViewById(a.e.lEx)).setText(p.b(this, getString(a.i.lHH, new Object[] { localObject1 })));
      localObject1 = (TextView)findViewById(a.e.lEy);
      if (!Util.isNullOrNil((CharSequence)localObject2)) {
        ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(241634);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setText(this.lDP);
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setSelection(ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).getText().length());
            this.lDQ.setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241634);
          }
        });
      }
      for (;;)
      {
        this.lDO = getString(a.i.settings_modify_remark_invalid_more);
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
  
  public void onInputPanelChange(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(241672);
    Log.i("MicroMsg.RemarkRoomNameUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.lDJ.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(a.c.Edge_2A);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(a.c.Edge_2A);
      this.lDJ.setLayoutParams(localLayoutParams);
      this.lDM.setPadding(this.lDM.getPaddingLeft(), this.lDM.getPaddingTop(), this.lDM.getPaddingRight(), paramInt);
      paramInt = this.lDL.getHeight();
      this.lDM.requestLayout();
      this.lDM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241645);
          Log.i("MicroMsg.RemarkRoomNameUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() > paramInt) {
            ModRemarkRoomNameUI.f(ModRemarkRoomNameUI.this).scrollBy(0, ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(241645);
        }
      });
      AppMethodBeat.o(241672);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.lDJ.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(a.c.Edge_12A);
    localLayoutParams.topMargin = 0;
    this.lDJ.setLayoutParams(localLayoutParams);
    this.lDM.setPadding(this.lDM.getPaddingLeft(), this.lDM.getPaddingTop(), this.lDM.getPaddingRight(), 0);
    this.lDL.scrollBy(0, 0);
    AppMethodBeat.o(241672);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI
 * JD-Core Version:    0.7.0.1
 */