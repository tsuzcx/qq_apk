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
import com.tencent.mm.ab.i;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.be;
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
  public String fIQ;
  private EmojiInfo glt;
  private d iNf;
  private ProgressBar jtq;
  private int mScene;
  private long pLp;
  private View pUL;
  private EmojiStatusView pUM;
  private ImageView pUN;
  private Button pUO;
  private Button pUP;
  private int pUQ;
  private int pUR;
  private DialogInterface.OnClickListener pUS;
  private DialogInterface.OnClickListener pUT;
  private View.OnClickListener pUU;
  
  public EmojiStoreV2SingleProductDialogUI()
  {
    AppMethodBeat.i(109310);
    this.pUS = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109305);
        EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          g.yxI.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(2), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109305);
      }
    };
    this.pUT = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109306);
        EmojiStoreV2SingleProductDialogUI.f(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          g.yxI.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(1), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109306);
      }
    };
    this.pUU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109307);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
  
  private void cjQ()
  {
    AppMethodBeat.i(109314);
    if ((this.glt != null) && (this.glt.field_catalog == EmojiGroupInfo.OzT))
    {
      this.pUP.setEnabled(false);
      this.pUP.setText(2131755275);
      this.pUP.setTextColor(getResources().getColor(2131100472));
      AppMethodBeat.o(109314);
      return;
    }
    if ((this.glt != null) && (this.glt.fxn()))
    {
      this.pUP.setEnabled(true);
      this.pUP.setText(2131758308);
      this.pUP.setTextColor(getResources().getColor(2131100035));
      AppMethodBeat.o(109314);
      return;
    }
    this.pUP.setEnabled(false);
    this.pUP.setText(2131758308);
    this.pUP.setTextColor(getResources().getColor(2131100472));
    AppMethodBeat.o(109314);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109313);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      this.iNf.setOnDismissListener(null);
      this.iNf.dismiss();
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
    this.pUQ = getIntent().getIntExtra("add_source", 5);
    this.pUR = getIntent().getIntExtra("entrance_scene", 0);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.pLp = getIntent().getLongExtra("searchID", 0L);
    this.fIQ = getIntent().getStringExtra("Select_Conv_User");
    paramBundle = getIntent().getByteArrayExtra("extra_object");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        localObject = new agk();
        ((agk)localObject).parseFrom(paramBundle);
        this.glt = k.getEmojiStorageMgr().JfU.aWl(((agk)localObject).Md5);
        if (this.glt == null)
        {
          this.glt = new EmojiInfo();
          this.glt.field_catalog = 84;
          this.glt.field_reserved4 |= EmojiInfo.OAp;
          com.tencent.mm.plugin.emoji.h.b.a((agk)localObject, this.glt);
        }
        if (this.glt == null)
        {
          setResult(0);
          finish();
        }
        this.pUL = z.jV(this).inflate(2131493823, null);
        this.jtq = ((ProgressBar)this.pUL.findViewById(2131299127));
        this.pUM = ((EmojiStatusView)this.pUL.findViewById(2131299125));
        this.pUN = ((ImageView)this.pUL.findViewById(2131299119));
        this.pUN.setOnClickListener(this.pUU);
        paramBundle = this.pUL;
        if (!((Activity)this).isFinishing()) {
          break label757;
        }
        paramBundle = null;
        this.iNf = paramBundle;
        this.iNf.a(getString(2131755884), false, this.pUS);
        this.iNf.b(getString(2131755275), false, this.pUT);
        this.iNf.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109308);
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            AppMethodBeat.o(109308);
          }
        });
        this.pUO = this.iNf.getButton(-1);
        this.pUP = this.iNf.getButton(-2);
        this.pUM.setVisibility(8);
        this.jtq.setVisibility(0);
        this.pUP.setText(2131758308);
        this.pUO.setText(2131755884);
        this.pUP.setEnabled(false);
        this.pUP.setTextColor(getResources().getColor(2131100472));
        this.pUO.setEnabled(false);
        this.pUO.setTextColor(getResources().getColor(2131100472));
        this.pUM.setStatusListener(new EmojiStatusView.b()
        {
          public final void mg(int paramAnonymousInt)
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
        this.pUM.setEmojiInfo(this.glt);
        AppMethodBeat.o(109311);
        return;
      }
      catch (IOException paramBundle)
      {
        ae.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", paramBundle, "", new Object[0]);
        setResult(0);
        finish();
        continue;
      }
      Object localObject = getIntent().getStringExtra("extra_object_json");
      paramBundle = new agk();
      try
      {
        localObject = new i((String)localObject);
        paramBundle.Md5 = ((i)localObject).optString("Md5");
        this.glt = k.getEmojiStorageMgr().JfU.aWl(paramBundle.Md5);
        if (this.glt == null)
        {
          this.glt = new EmojiInfo();
          this.glt.field_catalog = 84;
          this.glt.field_reserved4 |= EmojiInfo.OAp;
        }
        paramBundle.Url = ((i)localObject).optString("PreviewUrl");
        paramBundle.ThumbUrl = ((i)localObject).optString("ThumbUrl");
        paramBundle.AesKey = ((i)localObject).optString("AesKey");
        paramBundle.ProductID = ((i)localObject).optString("ProductID");
        paramBundle.ExternUrl = ((i)localObject).optString("ExternUrl");
        paramBundle.ExternMd5 = ((i)localObject).optString("ExternMd5");
        paramBundle.ActivityID = ((i)localObject).optString("ActivityID");
        com.tencent.mm.plugin.emoji.h.b.a(paramBundle, this.glt);
      }
      catch (Exception paramBundle)
      {
        setResult(0);
        finish();
      }
      continue;
      label757:
      localObject = new d.a(this);
      ((d.a)localObject).aZh("");
      ((d.a)localObject).hd(paramBundle);
      ((d.a)localObject).zf(true);
      paramBundle = ((d.a)localObject).fQv();
      paramBundle.show();
      h.a(this, paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109315);
    super.onDestroy();
    this.iNf.setOnDismissListener(null);
    if (this.iNf.isShowing()) {
      this.iNf.dismiss();
    }
    AppMethodBeat.o(109315);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109312);
    super.onResume();
    if (this.glt != null)
    {
      EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().JfU.aWl(this.glt.field_md5);
      if (localEmojiInfo != null) {
        this.glt = localEmojiInfo;
      }
    }
    cjQ();
    this.iNf.show();
    AppMethodBeat.o(109312);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI
 * JD-Core Version:    0.7.0.1
 */