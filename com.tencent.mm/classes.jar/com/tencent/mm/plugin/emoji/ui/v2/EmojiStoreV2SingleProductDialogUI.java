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
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.io.IOException;

public class EmojiStoreV2SingleProductDialogUI
  extends MMBaseActivity
{
  public String iSn;
  private EmojiInfo jHh;
  private int mScene;
  private d mpz;
  private ProgressBar njo;
  private long uEM;
  private View uOW;
  private EmojiStatusView uOX;
  private ImageView uOY;
  private Button uOZ;
  private Button uPa;
  private int uPb;
  private int uPc;
  private DialogInterface.OnClickListener uPd;
  private DialogInterface.OnClickListener uPe;
  private View.OnClickListener uPf;
  
  public EmojiStoreV2SingleProductDialogUI()
  {
    AppMethodBeat.i(109310);
    this.uPd = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109305);
        EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(2), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109305);
      }
    };
    this.uPe = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109306);
        EmojiStoreV2SingleProductDialogUI.f(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(1), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109306);
      }
    };
    this.uPf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109307);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).setOnDismissListener(null);
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).dismiss();
        EmojiStoreV2SingleProductDialogUI.this.setResult(0);
        EmojiStoreV2SingleProductDialogUI.this.finish();
        EmojiStoreV2SingleProductDialogUI.this.overridePendingTransition(i.a.pop_in, i.a.pop_out);
        a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109307);
      }
    };
    AppMethodBeat.o(109310);
  }
  
  private void cWy()
  {
    AppMethodBeat.i(109314);
    if ((this.jHh != null) && (this.jHh.field_catalog == EmojiGroupInfo.YCw))
    {
      this.uPa.setEnabled(false);
      this.uPa.setText(i.h.app_added);
      this.uPa.setTextColor(getResources().getColor(i.b.grey_btn_color_disable));
      AppMethodBeat.o(109314);
      return;
    }
    if ((this.jHh != null) && (this.jHh.hBp()))
    {
      this.uPa.setEnabled(true);
      this.uPa.setText(i.h.emoji_store_add_emoji);
      this.uPa.setTextColor(getResources().getColor(i.b.brand_text_color));
      AppMethodBeat.o(109314);
      return;
    }
    this.uPa.setEnabled(false);
    this.uPa.setText(i.h.emoji_store_add_emoji);
    this.uPa.setTextColor(getResources().getColor(i.b.grey_btn_color_disable));
    AppMethodBeat.o(109314);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109313);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      this.mpz.setOnDismissListener(null);
      this.mpz.dismiss();
      setResult(-1);
      finish();
      overridePendingTransition(i.a.pop_in, 0);
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
    this.uPb = getIntent().getIntExtra("add_source", 5);
    this.uPc = getIntent().getIntExtra("entrance_scene", 0);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.uEM = getIntent().getLongExtra("searchID", 0L);
    this.iSn = getIntent().getStringExtra("Select_Conv_User");
    paramBundle = getIntent().getByteArrayExtra("extra_object");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        localObject = new aji();
        ((aji)localObject).parseFrom(paramBundle);
        this.jHh = p.getEmojiStorageMgr().VFH.bxK(((aji)localObject).Md5);
        if (this.jHh == null)
        {
          this.jHh = new EmojiInfo();
          this.jHh.field_catalog = 84;
          this.jHh.field_reserved4 |= EmojiInfo.ZuM;
          com.tencent.mm.plugin.emoji.i.b.a((aji)localObject, this.jHh);
        }
        if (this.jHh == null)
        {
          setResult(0);
          finish();
        }
        this.uOW = ad.kS(this).inflate(i.f.emoji_store_v2_single_product_dialog, null);
        this.njo = ((ProgressBar)this.uOW.findViewById(i.e.dialog_loading));
        this.uOX = ((EmojiStatusView)this.uOW.findViewById(i.e.dialog_image));
        this.uOY = ((ImageView)this.uOW.findViewById(i.e.dialog_close));
        this.uOY.setOnClickListener(this.uPf);
        paramBundle = this.uOW;
        if (!((Activity)this).isFinishing()) {
          break label761;
        }
        paramBundle = null;
        this.mpz = paramBundle;
        this.mpz.a(getString(i.h.app_send), false, this.uPd);
        this.mpz.b(getString(i.h.app_added), false, this.uPe);
        this.mpz.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109308);
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            AppMethodBeat.o(109308);
          }
        });
        this.uOZ = this.mpz.ayb(-1);
        this.uPa = this.mpz.ayb(-2);
        this.uOX.setVisibility(8);
        this.njo.setVisibility(0);
        this.uPa.setText(i.h.emoji_store_add_emoji);
        this.uOZ.setText(i.h.app_send);
        this.uPa.setEnabled(false);
        this.uPa.setTextColor(getResources().getColor(i.b.grey_btn_color_disable));
        this.uOZ.setEnabled(false);
        this.uOZ.setTextColor(getResources().getColor(i.b.grey_btn_color_disable));
        this.uOX.setStatusListener(new EmojiStatusView.b()
        {
          public final void rH(int paramAnonymousInt)
          {
            AppMethodBeat.i(109309);
            if (paramAnonymousInt == 1)
            {
              EmojiStoreV2SingleProductDialogUI.h(EmojiStoreV2SingleProductDialogUI.this).setVisibility(0);
              EmojiStoreV2SingleProductDialogUI.i(EmojiStoreV2SingleProductDialogUI.this).setVisibility(8);
              EmojiStoreV2SingleProductDialogUI.j(EmojiStoreV2SingleProductDialogUI.this);
              EmojiStoreV2SingleProductDialogUI.k(EmojiStoreV2SingleProductDialogUI.this).setEnabled(true);
              EmojiStoreV2SingleProductDialogUI.k(EmojiStoreV2SingleProductDialogUI.this).setTextColor(EmojiStoreV2SingleProductDialogUI.this.getResources().getColor(i.b.brand_text_color));
            }
            AppMethodBeat.o(109309);
          }
        });
        this.uOX.setEmojiInfo(this.jHh);
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
      paramBundle = new aji();
      try
      {
        localObject = new i((String)localObject);
        paramBundle.Md5 = ((i)localObject).optString("Md5");
        this.jHh = p.getEmojiStorageMgr().VFH.bxK(paramBundle.Md5);
        if (this.jHh == null)
        {
          this.jHh = new EmojiInfo();
          this.jHh.field_catalog = 84;
          this.jHh.field_reserved4 |= EmojiInfo.ZuM;
        }
        paramBundle.Url = ((i)localObject).optString("PreviewUrl");
        paramBundle.ThumbUrl = ((i)localObject).optString("ThumbUrl");
        paramBundle.AesKey = ((i)localObject).optString("AesKey");
        paramBundle.ProductID = ((i)localObject).optString("ProductID");
        paramBundle.ExternUrl = ((i)localObject).optString("ExternUrl");
        paramBundle.ExternMd5 = ((i)localObject).optString("ExternMd5");
        paramBundle.ActivityID = ((i)localObject).optString("ActivityID");
        com.tencent.mm.plugin.emoji.i.b.a(paramBundle, this.jHh);
      }
      catch (Exception paramBundle)
      {
        setResult(0);
        finish();
      }
      continue;
      label761:
      localObject = new d.a(this);
      ((d.a)localObject).bBc("");
      ((d.a)localObject).iI(paramBundle);
      ((d.a)localObject).HG(true);
      paramBundle = ((d.a)localObject).icu();
      paramBundle.show();
      com.tencent.mm.ui.base.h.a(this, paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109315);
    super.onDestroy();
    this.mpz.setOnDismissListener(null);
    if (this.mpz.isShowing()) {
      this.mpz.dismiss();
    }
    AppMethodBeat.o(109315);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109312);
    super.onResume();
    if (this.jHh != null)
    {
      EmojiInfo localEmojiInfo = p.getEmojiStorageMgr().VFH.bxK(this.jHh.field_md5);
      if (localEmojiInfo != null) {
        this.jHh = localEmojiInfo;
      }
    }
    cWy();
    this.mpz.show();
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