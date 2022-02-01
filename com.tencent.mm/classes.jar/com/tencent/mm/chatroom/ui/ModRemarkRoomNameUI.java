package com.tencent.mm.chatroom.ui;

import android.app.Activity;
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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class ModRemarkRoomNameUI
  extends MMActivity
  implements b.a
{
  private String gxA;
  private MMClearEditText gxu;
  private Button gxv;
  private TextView gxw;
  private ScrollView gxx;
  private InputPanelLinearLayout gxy;
  private String gxz;
  private String roomId;
  private int scene;
  private TextView tipView;
  private TextView titleView;
  
  private void DI(String paramString)
  {
    AppMethodBeat.i(194174);
    if (Util.isNullOrNil(paramString))
    {
      this.gxw.setVisibility(8);
      AppMethodBeat.o(194174);
      return;
    }
    this.gxw.setVisibility(0);
    this.gxw.setText(paramString);
    AppMethodBeat.o(194174);
  }
  
  public final void f(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(194173);
    Log.i("MicroMsg.RemarkRoomNameUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.gxv.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165296);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165296);
      this.gxv.setLayoutParams(localLayoutParams);
      this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), paramInt);
      paramInt = this.gxx.getHeight();
      this.gxy.requestLayout();
      this.gxy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194168);
          Log.i("MicroMsg.RemarkRoomNameUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() > paramInt) {
            ModRemarkRoomNameUI.f(ModRemarkRoomNameUI.this).scrollBy(0, ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(194168);
        }
      });
      AppMethodBeat.o(194173);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.gxv.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165281);
    localLayoutParams.topMargin = 0;
    this.gxv.setLayoutParams(localLayoutParams);
    this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
    this.gxx.scrollBy(0, 0);
    AppMethodBeat.o(194173);
  }
  
  public int getLayoutId()
  {
    return 2131495681;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12668);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.gxx = ((ScrollView)findViewById(2131307339));
    this.gxy = ((InputPanelLinearLayout)findViewById(2131302671));
    this.gxy.setExternalListener(this);
    this.gxu = ((MMClearEditText)findViewById(2131304834));
    this.titleView = ((TextView)findViewById(2131304836));
    this.tipView = ((TextView)findViewById(2131304835));
    this.gxv = ((Button)findViewById(2131305423));
    this.gxw = ((TextView)findViewById(2131300161));
    Object localObject2 = (ImageView)findViewById(2131298296);
    Object localObject3 = findViewById(2131298307);
    this.scene = getIntent().getIntExtra("Key_Scenen", 0);
    this.roomId = getIntent().getStringExtra("Key_Room_Id");
    Log.i("MicroMsg.RemarkRoomNameUI", "scene %d, roomId %s", new Object[] { Integer.valueOf(this.scene), this.roomId });
    if (Util.isNullOrNil(this.roomId)) {
      finish();
    }
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
    if ((int)((com.tencent.mm.contact.c)localObject1).gMZ > 0) {
      com.tencent.mm.ui.g.a.a.c((ImageView)localObject2, ((ax)localObject1).field_username);
    }
    localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c(this, Util.nullAsNil(((ax)localObject1).field_nickname));
    localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c(this, Util.nullAsNil(((ax)localObject1).field_conRemark));
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
        this.gxu.setSelection(this.gxu.getText().length());
        this.gxu.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(194166);
            ModRemarkRoomNameUI.c(ModRemarkRoomNameUI.this).setEnabled(ModRemarkRoomNameUI.b(ModRemarkRoomNameUI.this));
            AppMethodBeat.o(194166);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(194165);
            if (paramAnonymousCharSequence.length() > 0)
            {
              ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(null);
              AppMethodBeat.o(194165);
              return;
            }
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(TextUtils.TruncateAt.END);
            AppMethodBeat.o(194165);
          }
        });
        com.tencent.mm.ui.tools.b.c.f(this.gxu).aoq(32).CN(false).a(null);
        this.gxu.requestFocus();
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
        this.gxv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(194167);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            ModRemarkRoomNameUI.d(ModRemarkRoomNameUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194167);
          }
        });
        AppMethodBeat.o(12668);
        return;
        this.titleView.setText(2131764655);
        this.tipView.setText(2131763144);
        this.gxu.setText((CharSequence)localObject2);
        if (Util.isNullOrNil((CharSequence)localObject2)) {
          this.gxu.setHint(getString(2131764704));
        }
        this.gxA = getString(2131764664);
        this.gxz = getString(2131764666);
        continue;
        this.titleView.setText(2131764734);
        this.tipView.setText(2131763142);
        localObject3 = this.gxu;
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = ((ah)localObject2).field_selfDisplayName;
        }
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = z.aUa();
        }
        ((MMClearEditText)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject2)));
        this.gxA = getString(2131764665);
        this.gxz = getString(2131764663);
      }
    }
    this.titleView.setText(2131764759);
    this.tipView.setText(2131763145);
    this.gxu.setText((CharSequence)localObject1);
    this.gxu.setHint(2131764759);
    if (Util.isNullOrNil((CharSequence)localObject2)) {}
    for (localObject1 = getString(2131764704);; localObject1 = localObject2)
    {
      ((View)localObject3).setVisibility(0);
      ((TextView)findViewById(2131298308)).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, getString(2131763143, new Object[] { localObject1 })));
      localObject1 = (TextView)findViewById(2131298309);
      if (!Util.isNullOrNil((CharSequence)localObject2)) {
        ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(194164);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setText(this.gxB);
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setSelection(ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).getText().length());
            this.gxC.setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194164);
          }
        });
      }
      for (;;)
      {
        this.gxA = getString(2131765479);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI
 * JD-Core Version:    0.7.0.1
 */