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
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.z;
import java.io.IOException;

public class EmojiStoreV2SingleProductDialogUI
  extends MMBaseActivity
{
  private EmojiInfo fPB;
  public String foE;
  private ProgressBar iXo;
  private d iri;
  private int mScene;
  private long pbb;
  private View pkG;
  private EmojiStatusView pkH;
  private ImageView pkI;
  private Button pkJ;
  private Button pkK;
  private int pkL;
  private int pkM;
  private DialogInterface.OnClickListener pkN;
  private DialogInterface.OnClickListener pkO;
  private View.OnClickListener pkP;
  
  public EmojiStoreV2SingleProductDialogUI()
  {
    AppMethodBeat.i(109310);
    this.pkN = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109305);
        EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.wUl.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(2), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109305);
      }
    };
    this.pkO = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109306);
        EmojiStoreV2SingleProductDialogUI.f(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.wUl.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(1), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109306);
      }
    };
    this.pkP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109307);
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).setOnDismissListener(null);
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).dismiss();
        EmojiStoreV2SingleProductDialogUI.this.setResult(0);
        EmojiStoreV2SingleProductDialogUI.this.finish();
        EmojiStoreV2SingleProductDialogUI.this.overridePendingTransition(2130772095, 2130772100);
        AppMethodBeat.o(109307);
      }
    };
    AppMethodBeat.o(109310);
  }
  
  private void cdX()
  {
    AppMethodBeat.i(109314);
    if ((this.fPB != null) && (this.fPB.field_catalog == EmojiGroupInfo.Jsr))
    {
      this.pkK.setEnabled(false);
      this.pkK.setText(2131755275);
      this.pkK.setTextColor(getResources().getColor(2131100472));
      AppMethodBeat.o(109314);
      return;
    }
    if ((this.fPB != null) && (this.fPB.fdp()))
    {
      this.pkK.setEnabled(true);
      this.pkK.setText(2131758308);
      this.pkK.setTextColor(getResources().getColor(2131100035));
      AppMethodBeat.o(109314);
      return;
    }
    this.pkK.setEnabled(false);
    this.pkK.setText(2131758308);
    this.pkK.setTextColor(getResources().getColor(2131100472));
    AppMethodBeat.o(109314);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109313);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      this.iri.setOnDismissListener(null);
      this.iri.dismiss();
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
    this.pkL = getIntent().getIntExtra("add_source", 5);
    this.pkM = getIntent().getIntExtra("entrance_scene", 0);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.pbb = getIntent().getLongExtra("searchID", 0L);
    this.foE = getIntent().getStringExtra("Select_Conv_User");
    paramBundle = getIntent().getByteArrayExtra("extra_object");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        localObject = new ads();
        ((ads)localObject).parseFrom(paramBundle);
        this.fPB = k.getEmojiStorageMgr().GXZ.aOT(((ads)localObject).Md5);
        if (this.fPB == null)
        {
          this.fPB = new EmojiInfo();
          this.fPB.field_catalog = 84;
          this.fPB.field_reserved4 |= EmojiInfo.Kgm;
          b.a((ads)localObject, this.fPB);
        }
        if (this.fPB == null)
        {
          setResult(0);
          finish();
        }
        this.pkG = z.jD(this).inflate(2131493823, null);
        this.iXo = ((ProgressBar)this.pkG.findViewById(2131299127));
        this.pkH = ((EmojiStatusView)this.pkG.findViewById(2131299125));
        this.pkI = ((ImageView)this.pkG.findViewById(2131299119));
        this.pkI.setOnClickListener(this.pkP);
        paramBundle = this.pkG;
        if (!((Activity)this).isFinishing()) {
          break label757;
        }
        paramBundle = null;
        this.iri = paramBundle;
        this.iri.a(getString(2131755884), false, this.pkN);
        this.iri.b(getString(2131755275), false, this.pkO);
        this.iri.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109308);
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            AppMethodBeat.o(109308);
          }
        });
        this.pkJ = this.iri.getButton(-1);
        this.pkK = this.iri.getButton(-2);
        this.pkH.setVisibility(8);
        this.iXo.setVisibility(0);
        this.pkK.setText(2131758308);
        this.pkJ.setText(2131755884);
        this.pkK.setEnabled(false);
        this.pkK.setTextColor(getResources().getColor(2131100472));
        this.pkJ.setEnabled(false);
        this.pkJ.setTextColor(getResources().getColor(2131100472));
        this.pkH.setStatusListener(new EmojiStatusView.b()
        {
          public final void lD(int paramAnonymousInt)
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
        this.pkH.setEmojiInfo(this.fPB);
        AppMethodBeat.o(109311);
        return;
      }
      catch (IOException paramBundle)
      {
        ac.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", paramBundle, "", new Object[0]);
        setResult(0);
        finish();
        continue;
      }
      Object localObject = getIntent().getStringExtra("extra_object_json");
      paramBundle = new ads();
      try
      {
        localObject = new i((String)localObject);
        paramBundle.Md5 = ((i)localObject).optString("Md5");
        this.fPB = k.getEmojiStorageMgr().GXZ.aOT(paramBundle.Md5);
        if (this.fPB == null)
        {
          this.fPB = new EmojiInfo();
          this.fPB.field_catalog = 84;
          this.fPB.field_reserved4 |= EmojiInfo.Kgm;
        }
        paramBundle.Url = ((i)localObject).optString("PreviewUrl");
        paramBundle.ThumbUrl = ((i)localObject).optString("ThumbUrl");
        paramBundle.AesKey = ((i)localObject).optString("AesKey");
        paramBundle.ProductID = ((i)localObject).optString("ProductID");
        paramBundle.ExternUrl = ((i)localObject).optString("ExternUrl");
        paramBundle.ExternMd5 = ((i)localObject).optString("ExternMd5");
        paramBundle.ActivityID = ((i)localObject).optString("ActivityID");
        b.a(paramBundle, this.fPB);
      }
      catch (Exception paramBundle)
      {
        setResult(0);
        finish();
      }
      continue;
      label757:
      localObject = new d.a(this);
      ((d.a)localObject).aRH("");
      ((d.a)localObject).gH(paramBundle);
      ((d.a)localObject).yf(true);
      paramBundle = ((d.a)localObject).fvp();
      paramBundle.show();
      com.tencent.mm.ui.base.h.a(this, paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109315);
    super.onDestroy();
    this.iri.setOnDismissListener(null);
    if (this.iri.isShowing()) {
      this.iri.dismiss();
    }
    AppMethodBeat.o(109315);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109312);
    super.onResume();
    if (this.fPB != null)
    {
      EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().GXZ.aOT(this.fPB.field_md5);
      if (localEmojiInfo != null) {
        this.fPB = localEmojiInfo;
      }
    }
    cdX();
    this.iri.show();
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