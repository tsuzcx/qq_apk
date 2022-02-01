package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.z;
import java.io.IOException;

public class EmojiStoreV2SingleProductDialogUI
  extends MMBaseActivity
{
  public String fGM;
  private EmojiInfo gjb;
  private d iKm;
  private ProgressBar jqx;
  private int mScene;
  private long pEL;
  private View pOg;
  private EmojiStatusView pOh;
  private ImageView pOi;
  private Button pOj;
  private Button pOk;
  private int pOl;
  private int pOm;
  private DialogInterface.OnClickListener pOn;
  private DialogInterface.OnClickListener pOo;
  private View.OnClickListener pOp;
  
  public EmojiStoreV2SingleProductDialogUI()
  {
    AppMethodBeat.i(109310);
    this.pOn = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109305);
        EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          g.yhR.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(2), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109305);
      }
    };
    this.pOo = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109306);
        EmojiStoreV2SingleProductDialogUI.f(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          g.yhR.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(1), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109306);
      }
    };
    this.pOp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109307);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).setOnDismissListener(null);
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).dismiss();
        EmojiStoreV2SingleProductDialogUI.this.setResult(0);
        EmojiStoreV2SingleProductDialogUI.this.finish();
        EmojiStoreV2SingleProductDialogUI.this.overridePendingTransition(2130772095, 2130772100);
        a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109307);
      }
    };
    AppMethodBeat.o(109310);
  }
  
  private void ciA()
  {
    AppMethodBeat.i(109314);
    if ((this.gjb != null) && (this.gjb.field_catalog == EmojiGroupInfo.OeM))
    {
      this.pOk.setEnabled(false);
      this.pOk.setText(2131755275);
      this.pOk.setTextColor(getResources().getColor(2131100472));
      AppMethodBeat.o(109314);
      return;
    }
    if ((this.gjb != null) && (this.gjb.fOu()))
    {
      this.pOk.setEnabled(true);
      this.pOk.setText(2131758308);
      this.pOk.setTextColor(getResources().getColor(2131100035));
      AppMethodBeat.o(109314);
      return;
    }
    this.pOk.setEnabled(false);
    this.pOk.setText(2131758308);
    this.pOk.setTextColor(getResources().getColor(2131100472));
    AppMethodBeat.o(109314);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109313);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      this.iKm.setOnDismissListener(null);
      this.iKm.dismiss();
      setResult(-1);
      finish();
      overridePendingTransition(2130772095, 0);
    }
    AppMethodBeat.o(109313);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109311);
    overridePendingTransition(-1, -1);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    this.pOl = getIntent().getIntExtra("add_source", 5);
    this.pOm = getIntent().getIntExtra("entrance_scene", 0);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.pEL = getIntent().getLongExtra("searchID", 0L);
    this.fGM = getIntent().getStringExtra("Select_Conv_User");
    paramBundle = getIntent().getByteArrayExtra("extra_object");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        localObject = new agb();
        ((agb)localObject).parseFrom(paramBundle);
        this.gjb = k.getEmojiStorageMgr().ILn.aUK(((agb)localObject).Md5);
        if (this.gjb == null)
        {
          this.gjb = new EmojiInfo();
          this.gjb.field_catalog = 84;
          this.gjb.field_reserved4 |= EmojiInfo.Ofi;
          com.tencent.mm.plugin.emoji.h.b.a((agb)localObject, this.gjb);
        }
        if (this.gjb == null)
        {
          setResult(0);
          finish();
        }
        this.pOg = z.jO(this).inflate(2131493823, null);
        this.jqx = ((ProgressBar)this.pOg.findViewById(2131299127));
        this.pOh = ((EmojiStatusView)this.pOg.findViewById(2131299125));
        this.pOi = ((ImageView)this.pOg.findViewById(2131299119));
        this.pOi.setOnClickListener(this.pOp);
        paramBundle = this.pOg;
        if (!((Activity)this).isFinishing()) {
          break label757;
        }
        paramBundle = null;
        this.iKm = paramBundle;
        this.iKm.a(getString(2131755884), false, this.pOn);
        this.iKm.b(getString(2131755275), false, this.pOo);
        this.iKm.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109308);
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            AppMethodBeat.o(109308);
          }
        });
        this.pOj = this.iKm.getButton(-1);
        this.pOk = this.iKm.getButton(-2);
        this.pOh.setVisibility(8);
        this.jqx.setVisibility(0);
        this.pOk.setText(2131758308);
        this.pOj.setText(2131755884);
        this.pOk.setEnabled(false);
        this.pOk.setTextColor(getResources().getColor(2131100472));
        this.pOj.setEnabled(false);
        this.pOj.setTextColor(getResources().getColor(2131100472));
        this.pOh.setStatusListener(new EmojiStatusView.b()
        {
          public final void md(int paramAnonymousInt)
          {
            AppMethodBeat.i(109309);
            if (paramAnonymousInt == 1)
            {
              EmojiStoreV2SingleProductDialogUI.h(EmojiStoreV2SingleProductDialogUI.this).setVisibility(0);
              EmojiStoreV2SingleProductDialogUI.i(EmojiStoreV2SingleProductDialogUI.this).setVisibility(8);
              EmojiStoreV2SingleProductDialogUI.j(EmojiStoreV2SingleProductDialogUI.this);
              EmojiStoreV2SingleProductDialogUI.k(EmojiStoreV2SingleProductDialogUI.this).setEnabled(true);
              EmojiStoreV2SingleProductDialogUI.k(EmojiStoreV2SingleProductDialogUI.this).setTextColor(EmojiStoreV2SingleProductDialogUI.this.getResources().getColor(2131100035));
            }
            AppMethodBeat.o(109309);
          }
        });
        this.pOh.setEmojiInfo(this.gjb);
        AppMethodBeat.o(109311);
        return;
      }
      catch (IOException paramBundle)
      {
        ad.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", paramBundle, "", new Object[0]);
        setResult(0);
        finish();
        continue;
      }
      Object localObject = getIntent().getStringExtra("extra_object_json");
      paramBundle = new agb();
      try
      {
        localObject = new i((String)localObject);
        paramBundle.Md5 = ((i)localObject).optString("Md5");
        this.gjb = k.getEmojiStorageMgr().ILn.aUK(paramBundle.Md5);
        if (this.gjb == null)
        {
          this.gjb = new EmojiInfo();
          this.gjb.field_catalog = 84;
          this.gjb.field_reserved4 |= EmojiInfo.Ofi;
        }
        paramBundle.Url = ((i)localObject).optString("PreviewUrl");
        paramBundle.ThumbUrl = ((i)localObject).optString("ThumbUrl");
        paramBundle.AesKey = ((i)localObject).optString("AesKey");
        paramBundle.ProductID = ((i)localObject).optString("ProductID");
        paramBundle.ExternUrl = ((i)localObject).optString("ExternUrl");
        paramBundle.ExternMd5 = ((i)localObject).optString("ExternMd5");
        paramBundle.ActivityID = ((i)localObject).optString("ActivityID");
        com.tencent.mm.plugin.emoji.h.b.a(paramBundle, this.gjb);
      }
      catch (Exception paramBundle)
      {
        setResult(0);
        finish();
      }
      continue;
      label757:
      localObject = new d.a(this);
      ((d.a)localObject).aXF("");
      ((d.a)localObject).gY(paramBundle);
      ((d.a)localObject).yR(true);
      paramBundle = ((d.a)localObject).fMb();
      paramBundle.show();
      h.a(this, paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109315);
    super.onDestroy();
    this.iKm.setOnDismissListener(null);
    if (this.iKm.isShowing()) {
      this.iKm.dismiss();
    }
    AppMethodBeat.o(109315);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109312);
    super.onResume();
    if (this.gjb != null)
    {
      EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().ILn.aUK(this.gjb.field_md5);
      if (localEmojiInfo != null) {
        this.gjb = localEmojiInfo;
      }
    }
    ciA();
    this.iKm.show();
    AppMethodBeat.o(109312);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI
 * JD-Core Version:    0.7.0.1
 */