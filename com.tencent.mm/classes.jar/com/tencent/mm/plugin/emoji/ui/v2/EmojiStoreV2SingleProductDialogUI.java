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
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.io.IOException;

public class EmojiStoreV2SingleProductDialogUI
  extends MMBaseActivity
{
  private EmojiInfo gWm;
  public String goe;
  private d jzT;
  private ProgressBar krF;
  private int mScene;
  private long rbH;
  private View rlK;
  private EmojiStatusView rlL;
  private ImageView rlM;
  private Button rlN;
  private Button rlO;
  private int rlP;
  private int rlQ;
  private DialogInterface.OnClickListener rlR;
  private DialogInterface.OnClickListener rlS;
  private View.OnClickListener rlT;
  
  public EmojiStoreV2SingleProductDialogUI()
  {
    AppMethodBeat.i(109310);
    this.rlR = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109305);
        EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.CyF.a(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(2), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109305);
      }
    };
    this.rlS = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109306);
        EmojiStoreV2SingleProductDialogUI.f(EmojiStoreV2SingleProductDialogUI.this);
        if (EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.CyF.a(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(EmojiStoreV2SingleProductDialogUI.this)), Integer.valueOf(1), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(EmojiStoreV2SingleProductDialogUI.this)), EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_designerID, EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this)) });
        }
        AppMethodBeat.o(109306);
      }
    };
    this.rlT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109307);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).setOnDismissListener(null);
        EmojiStoreV2SingleProductDialogUI.g(EmojiStoreV2SingleProductDialogUI.this).dismiss();
        EmojiStoreV2SingleProductDialogUI.this.setResult(0);
        EmojiStoreV2SingleProductDialogUI.this.finish();
        EmojiStoreV2SingleProductDialogUI.this.overridePendingTransition(2130772119, 2130772124);
        a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109307);
      }
    };
    AppMethodBeat.o(109310);
  }
  
  private void cHR()
  {
    AppMethodBeat.i(109314);
    if ((this.gWm != null) && (this.gWm.field_catalog == EmojiGroupInfo.Uuo))
    {
      this.rlO.setEnabled(false);
      this.rlO.setText(2131755310);
      this.rlO.setTextColor(getResources().getColor(2131100574));
      AppMethodBeat.o(109314);
      return;
    }
    if ((this.gWm != null) && (this.gWm.hRx()))
    {
      this.rlO.setEnabled(true);
      this.rlO.setText(2131758602);
      this.rlO.setTextColor(getResources().getColor(2131100063));
      AppMethodBeat.o(109314);
      return;
    }
    this.rlO.setEnabled(false);
    this.rlO.setText(2131758602);
    this.rlO.setTextColor(getResources().getColor(2131100574));
    AppMethodBeat.o(109314);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109313);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      this.jzT.setOnDismissListener(null);
      this.jzT.dismiss();
      setResult(-1);
      finish();
      overridePendingTransition(2130772119, 0);
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
    this.rlP = getIntent().getIntExtra("add_source", 5);
    this.rlQ = getIntent().getIntExtra("entrance_scene", 0);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.rbH = getIntent().getLongExtra("searchID", 0L);
    this.goe = getIntent().getStringExtra("Select_Conv_User");
    paramBundle = getIntent().getByteArrayExtra("extra_object");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        localObject = new ait();
        ((ait)localObject).parseFrom(paramBundle);
        this.gWm = k.getEmojiStorageMgr().OpN.blk(((ait)localObject).Md5);
        if (this.gWm == null)
        {
          this.gWm = new EmojiInfo();
          this.gWm.field_catalog = 84;
          this.gWm.field_reserved4 |= EmojiInfo.UuK;
          com.tencent.mm.plugin.emoji.h.b.a((ait)localObject, this.gWm);
        }
        if (this.gWm == null)
        {
          setResult(0);
          finish();
        }
        this.rlK = aa.jQ(this).inflate(2131493977, null);
        this.krF = ((ProgressBar)this.rlK.findViewById(2131299652));
        this.rlL = ((EmojiStatusView)this.rlK.findViewById(2131299650));
        this.rlM = ((ImageView)this.rlK.findViewById(2131299643));
        this.rlM.setOnClickListener(this.rlT);
        paramBundle = this.rlK;
        if (!((Activity)this).isFinishing()) {
          break label757;
        }
        paramBundle = null;
        this.jzT = paramBundle;
        this.jzT.a(getString(2131755976), false, this.rlR);
        this.jzT.b(getString(2131755310), false, this.rlS);
        this.jzT.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109308);
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            AppMethodBeat.o(109308);
          }
        });
        this.rlN = this.jzT.getButton(-1);
        this.rlO = this.jzT.getButton(-2);
        this.rlL.setVisibility(8);
        this.krF.setVisibility(0);
        this.rlO.setText(2131758602);
        this.rlN.setText(2131755976);
        this.rlO.setEnabled(false);
        this.rlO.setTextColor(getResources().getColor(2131100574));
        this.rlN.setEnabled(false);
        this.rlN.setTextColor(getResources().getColor(2131100574));
        this.rlL.setStatusListener(new EmojiStatusView.b()
        {
          public final void po(int paramAnonymousInt)
          {
            AppMethodBeat.i(109309);
            if (paramAnonymousInt == 1)
            {
              EmojiStoreV2SingleProductDialogUI.h(EmojiStoreV2SingleProductDialogUI.this).setVisibility(0);
              EmojiStoreV2SingleProductDialogUI.i(EmojiStoreV2SingleProductDialogUI.this).setVisibility(8);
              EmojiStoreV2SingleProductDialogUI.j(EmojiStoreV2SingleProductDialogUI.this);
              EmojiStoreV2SingleProductDialogUI.k(EmojiStoreV2SingleProductDialogUI.this).setEnabled(true);
              EmojiStoreV2SingleProductDialogUI.k(EmojiStoreV2SingleProductDialogUI.this).setTextColor(EmojiStoreV2SingleProductDialogUI.this.getResources().getColor(2131100063));
            }
            AppMethodBeat.o(109309);
          }
        });
        this.rlL.setEmojiInfo(this.gWm);
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
      paramBundle = new ait();
      try
      {
        localObject = new i((String)localObject);
        paramBundle.Md5 = ((i)localObject).optString("Md5");
        this.gWm = k.getEmojiStorageMgr().OpN.blk(paramBundle.Md5);
        if (this.gWm == null)
        {
          this.gWm = new EmojiInfo();
          this.gWm.field_catalog = 84;
          this.gWm.field_reserved4 |= EmojiInfo.UuK;
        }
        paramBundle.Url = ((i)localObject).optString("PreviewUrl");
        paramBundle.ThumbUrl = ((i)localObject).optString("ThumbUrl");
        paramBundle.AesKey = ((i)localObject).optString("AesKey");
        paramBundle.ProductID = ((i)localObject).optString("ProductID");
        paramBundle.ExternUrl = ((i)localObject).optString("ExternUrl");
        paramBundle.ExternMd5 = ((i)localObject).optString("ExternMd5");
        paramBundle.ActivityID = ((i)localObject).optString("ActivityID");
        com.tencent.mm.plugin.emoji.h.b.a(paramBundle, this.gWm);
      }
      catch (Exception paramBundle)
      {
        setResult(0);
        finish();
      }
      continue;
      label757:
      localObject = new d.a(this);
      ((d.a)localObject).bon("");
      ((d.a)localObject).hs(paramBundle);
      ((d.a)localObject).Dk(true);
      paramBundle = ((d.a)localObject).hbn();
      paramBundle.show();
      com.tencent.mm.ui.base.h.a(this, paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109315);
    super.onDestroy();
    this.jzT.setOnDismissListener(null);
    if (this.jzT.isShowing()) {
      this.jzT.dismiss();
    }
    AppMethodBeat.o(109315);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109312);
    super.onResume();
    if (this.gWm != null)
    {
      EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().OpN.blk(this.gWm.field_md5);
      if (localEmojiInfo != null) {
        this.gWm = localEmojiInfo;
      }
    }
    cHR();
    this.jzT.show();
    AppMethodBeat.o(109312);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI
 * JD-Core Version:    0.7.0.1
 */