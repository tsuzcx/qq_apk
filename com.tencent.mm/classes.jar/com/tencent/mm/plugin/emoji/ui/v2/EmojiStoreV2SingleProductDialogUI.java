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
import com.tencent.mm.ad.i;
import com.tencent.mm.emoji.f.b.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.io.IOException;

public class EmojiStoreV2SingleProductDialogUI
  extends MMBaseActivity
{
  public String luk;
  private int mScene;
  private String mToken;
  private EmojiInfo mgK;
  private e pjp;
  private ProgressBar qgC;
  private long xNo;
  private View xXG;
  private EmojiStatusView xXH;
  private ImageView xXI;
  private Button xXJ;
  private Button xXK;
  private int xXL;
  private int xXM;
  private DialogInterface.OnClickListener xXN;
  private DialogInterface.OnClickListener xXO;
  private View.OnClickListener xXP;
  
  public EmojiStoreV2SingleProductDialogUI()
  {
    AppMethodBeat.i(109310);
    this.xXN = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109305);
        EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.emoji.ui.v3.b.a.a(EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this), 2, EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this), EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this), EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this));
        }
        AppMethodBeat.o(109305);
      }
    };
    this.xXO = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109306);
        EmojiStoreV2SingleProductDialogUI.f(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.emoji.ui.v3.b.a.a(EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this), 1, EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this), EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this), EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this));
        }
        AppMethodBeat.o(109306);
      }
    };
    this.xXP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109307);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).setOnDismissListener(null);
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).dismiss();
        EmojiStoreV2SingleProductDialogUI.this.setResult(0);
        EmojiStoreV2SingleProductDialogUI.this.finish();
        EmojiStoreV2SingleProductDialogUI.this.overridePendingTransition(h.a.pop_in, h.a.pop_out);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109307);
      }
    };
    AppMethodBeat.o(109310);
  }
  
  private void dCc()
  {
    AppMethodBeat.i(109314);
    if ((this.mgK != null) && (this.mgK.field_catalog == EmojiGroupInfo.aklF))
    {
      this.xXK.setEnabled(false);
      this.xXK.setText(h.h.app_added);
      this.xXK.setTextColor(getResources().getColor(h.b.grey_btn_color_disable));
      AppMethodBeat.o(109314);
      return;
    }
    if ((this.mgK != null) && (this.mgK.kLZ()))
    {
      this.xXK.setEnabled(true);
      this.xXK.setText(h.h.emoji_store_add_emoji);
      this.xXK.setTextColor(getResources().getColor(h.b.brand_text_color));
      AppMethodBeat.o(109314);
      return;
    }
    this.xXK.setEnabled(false);
    this.xXK.setText(h.h.emoji_store_add_emoji);
    this.xXK.setTextColor(getResources().getColor(h.b.grey_btn_color_disable));
    AppMethodBeat.o(109314);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109313);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      this.pjp.setOnDismissListener(null);
      this.pjp.dismiss();
      setResult(-1);
      finish();
      overridePendingTransition(h.a.pop_in, 0);
    }
    AppMethodBeat.o(109313);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109311);
    overridePendingTransition(-1, -1);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    this.xXL = getIntent().getIntExtra("add_source", 5);
    this.xXM = getIntent().getIntExtra("entrance_scene", 0);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.xNo = getIntent().getLongExtra("searchID", 0L);
    this.luk = getIntent().getStringExtra("Select_Conv_User");
    this.mToken = getIntent().getStringExtra("ad_uxInfo");
    paramBundle = getIntent().getByteArrayExtra("extra_object");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        localObject = new amn();
        ((amn)localObject).parseFrom(paramBundle);
        this.mgK = s.getEmojiStorageMgr().adju.bza(((amn)localObject).Md5);
        if (this.mgK == null)
        {
          this.mgK = new EmojiInfo();
          this.mgK.field_catalog = 84;
          this.mgK.field_reserved4 |= EmojiInfo.akmb;
          d.a((amn)localObject, this.mgK);
        }
        if (this.mgK == null)
        {
          setResult(0);
          finish();
        }
        this.xXG = af.mU(this).inflate(h.f.emoji_store_v2_single_product_dialog, null);
        this.qgC = ((ProgressBar)this.xXG.findViewById(h.e.dialog_loading));
        this.xXH = ((EmojiStatusView)this.xXG.findViewById(h.e.dialog_image));
        this.xXI = ((ImageView)this.xXG.findViewById(h.e.dialog_close));
        this.xXI.setContentDescription(getString(h.h.app_close));
        this.xXI.setOnClickListener(this.xXP);
        paramBundle = this.xXG;
        if (!((Activity)this).isFinishing()) {
          break label788;
        }
        paramBundle = null;
        this.pjp = paramBundle;
        this.pjp.a(getString(h.h.app_send), false, this.xXN);
        this.pjp.b(getString(h.h.app_added), false, this.xXO);
        this.pjp.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109308);
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            AppMethodBeat.o(109308);
          }
        });
        this.xXJ = this.pjp.aEJ(-1);
        this.xXK = this.pjp.aEJ(-2);
        this.xXH.setVisibility(8);
        this.qgC.setVisibility(0);
        this.xXK.setText(h.h.emoji_store_add_emoji);
        this.xXJ.setText(h.h.app_send);
        this.xXK.setEnabled(false);
        this.xXK.setTextColor(getResources().getColor(h.b.grey_btn_color_disable));
        this.xXJ.setEnabled(false);
        this.xXJ.setTextColor(getResources().getColor(h.b.grey_btn_color_disable));
        this.xXH.setStatusListener(new EmojiStatusView.b()
        {
          public final void rJ(int paramAnonymousInt)
          {
            AppMethodBeat.i(109309);
            if (paramAnonymousInt == 1)
            {
              EmojiStoreV2SingleProductDialogUI.h(EmojiStoreV2SingleProductDialogUI.this).setVisibility(0);
              EmojiStoreV2SingleProductDialogUI.i(EmojiStoreV2SingleProductDialogUI.this).setVisibility(8);
              EmojiStoreV2SingleProductDialogUI.j(EmojiStoreV2SingleProductDialogUI.this);
              EmojiStoreV2SingleProductDialogUI.k(EmojiStoreV2SingleProductDialogUI.this).setEnabled(true);
              EmojiStoreV2SingleProductDialogUI.k(EmojiStoreV2SingleProductDialogUI.this).setTextColor(EmojiStoreV2SingleProductDialogUI.this.getResources().getColor(h.b.brand_text_color));
            }
            AppMethodBeat.o(109309);
          }
        });
        this.xXH.setEmojiInfo(this.mgK);
        AppMethodBeat.o(109311);
        return;
      }
      catch (IOException paramBundle)
      {
        Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", paramBundle, "", new Object[0]);
        setResult(0);
        finish();
        continue;
      }
      Object localObject = getIntent().getStringExtra("extra_object_json");
      paramBundle = new amn();
      try
      {
        localObject = new i((String)localObject);
        paramBundle.Md5 = ((i)localObject).optString("Md5");
        this.mgK = s.getEmojiStorageMgr().adju.bza(paramBundle.Md5);
        if (this.mgK == null)
        {
          this.mgK = new EmojiInfo();
          this.mgK.field_catalog = 84;
          this.mgK.field_reserved4 |= EmojiInfo.akmb;
        }
        paramBundle.Url = ((i)localObject).optString("PreviewUrl");
        paramBundle.ThumbUrl = ((i)localObject).optString("ThumbUrl");
        paramBundle.AesKey = ((i)localObject).optString("AesKey");
        paramBundle.ProductID = ((i)localObject).optString("ProductID");
        paramBundle.ExternUrl = ((i)localObject).optString("ExternUrl");
        paramBundle.ExternMd5 = ((i)localObject).optString("ExternMd5");
        paramBundle.ActivityID = ((i)localObject).optString("ActivityID");
        d.a(paramBundle, this.mgK);
      }
      catch (Exception paramBundle)
      {
        setResult(0);
        finish();
      }
      continue;
      label788:
      localObject = new e.a(this);
      ((e.a)localObject).bDv("");
      ((e.a)localObject).md(paramBundle);
      ((e.a)localObject).NC(true);
      paramBundle = ((e.a)localObject).jHH();
      paramBundle.show();
      k.a(this, paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109315);
    super.onDestroy();
    this.pjp.setOnDismissListener(null);
    if (this.pjp.isShowing()) {
      this.pjp.dismiss();
    }
    AppMethodBeat.o(109315);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109312);
    super.onResume();
    if (this.mgK != null)
    {
      EmojiInfo localEmojiInfo = s.getEmojiStorageMgr().adju.bza(this.mgK.field_md5);
      if (localEmojiInfo != null) {
        this.mgK = localEmojiInfo;
      }
    }
    dCc();
    this.pjp.show();
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