package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.i;
import com.tencent.mm.modelavatar.i.b;
import com.tencent.mm.plugin.account.sdk.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.protocal.protobuf.eot;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMClearEditText;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Map;

public class RegAffiliateAccountUI
  extends MMActivity
{
  private Button lDJ;
  private String nickName;
  private String qeA;
  private boolean qer = true;
  private MMClearEditText qes;
  MMClearEditText qet;
  MMClearEditText qeu;
  private CheckBox qev;
  private Button qew;
  private String qex;
  private String qey;
  private String qez;
  private w tipDialog;
  
  final void a(a.a parama)
  {
    AppMethodBeat.i(305056);
    switch (2.pXF[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(305056);
      return;
      k.s(this, r.j.regbymobile_reg_setpwd_alert_diff, r.j.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(305056);
      return;
      k.s(this, r.j.regbymobile_reg_setpwd_alert_more_byte, r.j.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(305056);
      return;
      k.s(this, r.j.verify_password_all_num_tip, r.j.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(305056);
      return;
      k.s(this, r.j.verify_password_tip, r.j.regbymobile_reg_setpwd_alert_title);
    }
  }
  
  public int getLayoutId()
  {
    return r.g.reg_affiliate_account;
  }
  
  public void initView()
  {
    AppMethodBeat.i(305048);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(r.c.white));
    Object localObject;
    String str1;
    String str2;
    if (this.qer)
    {
      findViewById(r.f.panel_set_nickname).setVisibility(0);
      this.lDJ = ((Button)findViewById(r.f.next_btn));
      this.lDJ.setEnabled(false);
      this.qes = ((MMClearEditText)findViewById(r.f.nickname_et));
      com.tencent.mm.ui.tools.b.c.i(this.qes).oF(1, 32).Nc(false).a(null);
      this.lDJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305230);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegAffiliateAccountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RegAffiliateAccountUI.this.hideVKB();
          paramAnonymousView = new Intent(RegAffiliateAccountUI.this, RegAffiliateAccountUI.class);
          paramAnonymousView.putExtra("RegTicket", RegAffiliateAccountUI.a(RegAffiliateAccountUI.this));
          paramAnonymousView.putExtra("sessionID", RegAffiliateAccountUI.b(RegAffiliateAccountUI.this));
          paramAnonymousView.putExtra("NickName", RegAffiliateAccountUI.c(RegAffiliateAccountUI.this));
          paramAnonymousView.putExtra("AvatarFileID", RegAffiliateAccountUI.d(RegAffiliateAccountUI.this));
          paramAnonymousView.putExtra("AvatarAESKey", RegAffiliateAccountUI.e(RegAffiliateAccountUI.this));
          paramAnonymousView.putExtra("STEP_ONE", false);
          RegAffiliateAccountUI.this.startActivityForResult(paramAnonymousView, 702);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegAffiliateAccountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305230);
        }
      });
      this.qes.requestFocus();
      this.qes.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(305213);
          RegAffiliateAccountUI.a(RegAffiliateAccountUI.this, RegAffiliateAccountUI.f(RegAffiliateAccountUI.this).getText().toString().trim());
          RegAffiliateAccountUI.g(RegAffiliateAccountUI.this);
          AppMethodBeat.o(305213);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      findViewById(r.f.setinfo_avatar_ly).setOnClickListener(new RegAffiliateAccountUI.5(this));
      findViewById(r.f.reg_term).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305207);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegAffiliateAccountUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = com.tencent.mm.au.b.bJ("CN", RegAffiliateAccountUI.this.getString(r.j.country_code));
          com.tencent.mm.plugin.account.sdk.c.a.b(RegAffiliateAccountUI.this, RegAffiliateAccountUI.this.getString(r.j.url_agreement, new Object[] { LocaleUtil.getApplicationLanguage(), paramAnonymousView }), 0, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegAffiliateAccountUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305207);
        }
      });
      localObject = (CheckBox)findViewById(r.f.reg_term_check);
      this.qev = ((CheckBox)localObject);
      ((CheckBox)localObject).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(305201);
          RegAffiliateAccountUI.g(RegAffiliateAccountUI.this);
          AppMethodBeat.o(305201);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(305228);
          RegAffiliateAccountUI.this.onBackPressed();
          AppMethodBeat.o(305228);
          return true;
        }
      });
      localObject = h.OAn;
      str1 = this.qey;
      str2 = com.tencent.mm.compatible.deviceinfo.q.aPg();
      if (!this.qer) {
        break label377;
      }
    }
    label377:
    for (int i = 1005;; i = 1006)
    {
      ((h)localObject).b(23530, new Object[] { str1, str2, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(305048);
      return;
      findViewById(r.f.panel_set_pass).setVisibility(0);
      this.qet = ((MMClearEditText)findViewById(r.f.pass_et));
      this.qeu = ((MMClearEditText)findViewById(r.f.confirm_pass_et));
      this.qew = ((Button)findViewById(r.f.complete_btn));
      this.qew.setEnabled(true);
      this.qew.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305204);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegAffiliateAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          h.OAn.b(23530, new Object[] { RegAffiliateAccountUI.b(RegAffiliateAccountUI.this), com.tencent.mm.compatible.deviceinfo.q.aPg(), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(1006), Integer.valueOf(10601) });
          paramAnonymousView = RegAffiliateAccountUI.this;
          localObject = paramAnonymousView.qet.getText().toString();
          String str = paramAnonymousView.qeu.getText().toString();
          int i;
          if (Util.isNullOrNil((String)localObject)) {
            i = 0;
          }
          for (;;)
          {
            if (i != 0) {
              RegAffiliateAccountUI.h(RegAffiliateAccountUI.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegAffiliateAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(305204);
            return;
            if (!((String)localObject).equals(str))
            {
              paramAnonymousView.a(a.a.pXG);
              i = 0;
            }
            else if (((String)localObject).length() > 16)
            {
              paramAnonymousView.a(a.a.pXH);
              i = 0;
            }
            else if (Util.isChinese((String)localObject))
            {
              k.s(paramAnonymousView, r.j.regbyfacebook_reg_setpwd_alert_using_chinese, r.j.regbymobile_reg_setpwd_alert_title);
              i = 0;
            }
            else
            {
              if (!Util.isValidPassword((String)localObject))
              {
                if ((((String)localObject).length() >= 8) && (((String)localObject).length() < 16)) {
                  paramAnonymousView.a(a.a.pXJ);
                }
                for (;;)
                {
                  i = 0;
                  break;
                  paramAnonymousView.a(a.a.pXI);
                }
              }
              paramAnonymousView.hideVKB();
              i = 1;
            }
          }
        }
      });
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(305053);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 702) && (paramInt2 == -1))
    {
      setResult(-1, paramIntent);
      finish();
      AppMethodBeat.o(305053);
      return;
    }
    if (com.tencent.mm.plugin.account.sdk.a.pFo.b(this, paramInt1, paramInt2, paramIntent) != null)
    {
      paramIntent = com.tencent.mm.loader.i.b.bmH() + "temp.avatar";
      new i(paramIntent, new i.b()
      {
        public final void LR(String paramAnonymousString)
        {
          AppMethodBeat.i(305195);
          y.deleteFile(com.tencent.mm.loader.i.b.bmH() + "temp.avatar");
          if ((RegAffiliateAccountUI.i(RegAffiliateAccountUI.this) != null) && (RegAffiliateAccountUI.i(RegAffiliateAccountUI.this).isShowing())) {
            RegAffiliateAccountUI.i(RegAffiliateAccountUI.this).dismiss();
          }
          AppMethodBeat.o(305195);
        }
        
        public final void br(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(305199);
          RegAffiliateAccountUI.b(RegAffiliateAccountUI.this, paramAnonymousString1);
          RegAffiliateAccountUI.c(RegAffiliateAccountUI.this, paramAnonymousString2);
          RegAffiliateAccountUI.this.findViewById(r.f.setinfo_camera).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(305014);
              RegAffiliateAccountUI.this.findViewById(r.f.setinfo_camera).setVisibility(8);
              ((ImageView)RegAffiliateAccountUI.this.findViewById(r.f.setinfo_avatar)).setImageBitmap(MMBitmapFactory.decodeFile(RegAffiliateAccountUI.9.this.oHA));
              if ((RegAffiliateAccountUI.i(RegAffiliateAccountUI.this) != null) && (RegAffiliateAccountUI.i(RegAffiliateAccountUI.this).isShowing())) {
                RegAffiliateAccountUI.i(RegAffiliateAccountUI.this).dismiss();
              }
              AppMethodBeat.o(305014);
            }
          });
          AppMethodBeat.o(305199);
        }
      }).bFu();
      paramIntent = getContext();
      getString(r.j.app_tip);
      this.tipDialog = k.a(paramIntent, getString(r.j.app_waiting), true, null);
    }
    AppMethodBeat.o(305053);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(305058);
    super.onBackPressed();
    AppMethodBeat.o(305058);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305040);
    super.onCreate(paramBundle);
    this.qex = getIntent().getStringExtra("RegTicket");
    this.qey = getIntent().getStringExtra("sessionID");
    this.nickName = getIntent().getStringExtra("NickName");
    this.qez = getIntent().getStringExtra("AvatarFileID");
    this.qeA = getIntent().getStringExtra("AvatarAESKey");
    this.qer = getIntent().getBooleanExtra("STEP_ONE", true);
    initView();
    AppMethodBeat.o(305040);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(305044);
    super.onDestroy();
    AppMethodBeat.o(305044);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(305059);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(305059);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(305059);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(305050);
    if (paramInt == 34)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        com.tencent.mm.plugin.account.sdk.a.pFo.t(this);
        AppMethodBeat.o(305050);
      }
    }
    else {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(305050);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegAffiliateAccountUI
 * JD-Core Version:    0.7.0.1
 */