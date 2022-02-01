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
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.y;
import java.io.IOException;

public class EmojiStoreV2SingleProductDialogUI
  extends MMBaseActivity
{
  private EmojiInfo fLP;
  public String flk;
  private d hRe;
  private ProgressBar ixl;
  private int mScene;
  private View oHg;
  private EmojiStatusView oHh;
  private ImageView oHi;
  private Button oHj;
  private Button oHk;
  private int oHl;
  private int oHm;
  private DialogInterface.OnClickListener oHn;
  private DialogInterface.OnClickListener oHo;
  private View.OnClickListener oHp;
  private long oxB;
  
  public EmojiStoreV2SingleProductDialogUI()
  {
    AppMethodBeat.i(109310);
    this.oHn = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109305);
        EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.vKh.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(2), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109305);
      }
    };
    this.oHo = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109306);
        EmojiStoreV2SingleProductDialogUI.f(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.vKh.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(1), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109306);
      }
    };
    this.oHp = new View.OnClickListener()
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
  
  private void bWK()
  {
    AppMethodBeat.i(109314);
    if ((this.fLP != null) && (this.fLP.field_catalog == EmojiGroupInfo.LBP))
    {
      this.oHk.setEnabled(false);
      this.oHk.setText(2131755275);
      this.oHk.setTextColor(getResources().getColor(2131100472));
      AppMethodBeat.o(109314);
      return;
    }
    if ((this.fLP != null) && (this.fLP.fZM()))
    {
      this.oHk.setEnabled(true);
      this.oHk.setText(2131758308);
      this.oHk.setTextColor(getResources().getColor(2131100035));
      AppMethodBeat.o(109314);
      return;
    }
    this.oHk.setEnabled(false);
    this.oHk.setText(2131758308);
    this.oHk.setTextColor(getResources().getColor(2131100472));
    AppMethodBeat.o(109314);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109313);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      this.hRe.setOnDismissListener(null);
      this.hRe.dismiss();
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
    this.oHl = getIntent().getIntExtra("add_source", 5);
    this.oHm = getIntent().getIntExtra("entrance_scene", 0);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.oxB = getIntent().getLongExtra("searchID", 0L);
    this.flk = getIntent().getStringExtra("Select_Conv_User");
    paramBundle = getIntent().getByteArrayExtra("extra_object");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        localObject = new act();
        ((act)localObject).parseFrom(paramBundle);
        this.fLP = k.getEmojiStorageMgr().FyY.aJx(((act)localObject).Md5);
        if (this.fLP == null)
        {
          this.fLP = new EmojiInfo();
          this.fLP.field_catalog = 84;
          this.fLP.field_reserved4 |= EmojiInfo.LCl;
          b.a((act)localObject, this.fLP);
        }
        if (this.fLP == null)
        {
          setResult(0);
          finish();
        }
        this.oHg = y.js(this).inflate(2131493823, null);
        this.ixl = ((ProgressBar)this.oHg.findViewById(2131299127));
        this.oHh = ((EmojiStatusView)this.oHg.findViewById(2131299125));
        this.oHi = ((ImageView)this.oHg.findViewById(2131299119));
        this.oHi.setOnClickListener(this.oHp);
        paramBundle = this.oHg;
        if (!((Activity)this).isFinishing()) {
          break label757;
        }
        paramBundle = null;
        this.hRe = paramBundle;
        this.hRe.a(getString(2131755884), false, this.oHn);
        this.hRe.b(getString(2131755275), false, this.oHo);
        this.hRe.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109308);
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            AppMethodBeat.o(109308);
          }
        });
        this.oHj = this.hRe.getButton(-1);
        this.oHk = this.hRe.getButton(-2);
        this.oHh.setVisibility(8);
        this.ixl.setVisibility(0);
        this.oHk.setText(2131758308);
        this.oHj.setText(2131755884);
        this.oHk.setEnabled(false);
        this.oHk.setTextColor(getResources().getColor(2131100472));
        this.oHj.setEnabled(false);
        this.oHj.setTextColor(getResources().getColor(2131100472));
        this.oHh.setStatusListener(new EmojiStatusView.b()
        {
          public final void lG(int paramAnonymousInt)
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
        this.oHh.setEmojiInfo(this.fLP);
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
      paramBundle = new act();
      try
      {
        localObject = new i((String)localObject);
        paramBundle.Md5 = ((i)localObject).optString("Md5");
        this.fLP = k.getEmojiStorageMgr().FyY.aJx(paramBundle.Md5);
        if (this.fLP == null)
        {
          this.fLP = new EmojiInfo();
          this.fLP.field_catalog = 84;
          this.fLP.field_reserved4 |= EmojiInfo.LCl;
        }
        paramBundle.Url = ((i)localObject).optString("PreviewUrl");
        paramBundle.ThumbUrl = ((i)localObject).optString("ThumbUrl");
        paramBundle.AesKey = ((i)localObject).optString("AesKey");
        paramBundle.ProductID = ((i)localObject).optString("ProductID");
        paramBundle.ExternUrl = ((i)localObject).optString("ExternUrl");
        paramBundle.ExternMd5 = ((i)localObject).optString("ExternMd5");
        paramBundle.ActivityID = ((i)localObject).optString("ActivityID");
        b.a(paramBundle, this.fLP);
      }
      catch (Exception paramBundle)
      {
        setResult(0);
        finish();
      }
      continue;
      label757:
      localObject = new d.a(this);
      ((d.a)localObject).aMf("");
      ((d.a)localObject).gs(paramBundle);
      ((d.a)localObject).wX(true);
      paramBundle = ((d.a)localObject).fft();
      paramBundle.show();
      com.tencent.mm.ui.base.h.a(this, paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109315);
    super.onDestroy();
    this.hRe.setOnDismissListener(null);
    if (this.hRe.isShowing()) {
      this.hRe.dismiss();
    }
    AppMethodBeat.o(109315);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109312);
    super.onResume();
    if (this.fLP != null)
    {
      EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().FyY.aJx(this.fLP.field_md5);
      if (localEmojiInfo != null) {
        this.fLP = localEmojiInfo;
      }
    }
    bWK();
    this.hRe.show();
    AppMethodBeat.o(109312);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI
 * JD-Core Version:    0.7.0.1
 */