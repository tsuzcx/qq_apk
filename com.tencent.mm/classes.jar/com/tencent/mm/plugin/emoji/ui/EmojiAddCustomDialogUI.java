package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.c.d.a;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dk.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.tools.b.b.a;
import com.tencent.mm.vending.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiAddCustomDialogUI
  extends MMBaseActivity
  implements com.tencent.mm.al.f
{
  private ProgressDialog iYL;
  private String ksR;
  private Context mContext;
  private int mScene;
  private boolean obY;
  private String pIm;
  private EmojiInfo pIn;
  private boolean pIo;
  private com.tencent.mm.emoji.c.d pIp;
  private com.tencent.mm.ui.widget.a.d pIq;
  private com.tencent.mm.ui.widget.a.d pIr;
  private c<com.tencent.mm.vending.e.a> pIs;
  private Runnable pIt;
  
  public EmojiAddCustomDialogUI()
  {
    AppMethodBeat.i(108842);
    this.pIt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108829);
        EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(2131758389));
        AppMethodBeat.o(108829);
      }
    };
    AppMethodBeat.o(108842);
  }
  
  private void abY(String paramString)
  {
    AppMethodBeat.i(108849);
    if (isFinishing())
    {
      AppMethodBeat.o(108849);
      return;
    }
    this.pIr = com.tencent.mm.ui.base.h.c(this, paramString, "", true);
    this.pIr.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(198748);
        EmojiAddCustomDialogUI.this.setResult(1);
        EmojiAddCustomDialogUI.this.finish();
        AppMethodBeat.o(198748);
      }
    });
    AppMethodBeat.o(108849);
  }
  
  private static void chP()
  {
    AppMethodBeat.i(108846);
    Object localObject = new dk();
    ((dk)localObject).dog.type = 1;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    if (!((dk)localObject).doh.doi)
    {
      localObject = k.getEmojiStorageMgr().ILq.ftD();
      if (localObject != null)
      {
        Iterator localIterator = ((deu)localObject).Htk.iterator();
        while (localIterator.hasNext())
        {
          dev localdev = (dev)localIterator.next();
          if (localdev.ProductID.equals(String.valueOf(EmojiGroupInfo.OeL))) {
            localdev.FCk = 0;
          }
        }
      }
      k.getEmojiStorageMgr().ILq.a((deu)localObject);
      com.tencent.mm.cb.a.fhy();
      localObject = com.tencent.mm.cb.a.HVh;
      a.b.aPD(String.valueOf(EmojiGroupInfo.OeL));
    }
    AppMethodBeat.o(108846);
  }
  
  private void chQ()
  {
    AppMethodBeat.i(108848);
    if (isFinishing())
    {
      AppMethodBeat.o(108848);
      return;
    }
    this.pIq = com.tencent.mm.ui.base.h.a(this.mContext, 2131758413, 2131755726, 2131758337, 2131755691, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(198758);
        Object localObject = new Intent();
        com.tencent.mm.plugin.report.service.g.yhR.f(11596, new Object[] { Integer.valueOf(3) });
        ((Intent)localObject).setClass(EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this), EmojiCustomUI.class);
        ((Intent)localObject).putExtra("key_emoji_panel_type", 0);
        paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(198758);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(108840);
        EmojiAddCustomDialogUI.this.setResult(3);
        EmojiAddCustomDialogUI.this.finish();
        AppMethodBeat.o(108840);
      }
    });
    if (this.pIq != null) {
      this.pIq.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(198759);
          EmojiAddCustomDialogUI.this.setResult(3);
          EmojiAddCustomDialogUI.this.finish();
          AppMethodBeat.o(198759);
        }
      });
    }
    AppMethodBeat.o(108848);
  }
  
  private void v(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108847);
    ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmojiInfo.Lb());
    paramEmojiInfo = new com.tencent.mm.emoji.sync.a(0, localArrayList);
    paramEmojiInfo.hNz = true;
    paramEmojiInfo.aED().a(this.pIs).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(a.a<hy> paramAnonymousa)
      {
        AppMethodBeat.i(198753);
        int i = paramAnonymousa.errType;
        int j = paramAnonymousa.errCode;
        if (j == -434)
        {
          ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
          paramAnonymousa = j.gkf;
          j.dp(true);
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqv, Boolean.TRUE);
          EmojiAddCustomDialogUI.this.chI();
          EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this);
          com.tencent.mm.plugin.report.service.g.yhR.f(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.c(EmojiAddCustomDialogUI.this)), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).Lb(), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_designerID, EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_size), EmojiAddCustomDialogUI.e(EmojiAddCustomDialogUI.this), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_activityid });
        }
        for (;;)
        {
          paramAnonymousa = LhQ;
          AppMethodBeat.o(198753);
          return paramAnonymousa;
          if ((i == 0) && (j == 0))
          {
            ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
            paramAnonymousa = (hy)paramAnonymousa.hNC;
            if ((paramAnonymousa != null) && (paramAnonymousa.FAv != null) && (paramAnonymousa.FAv.size() > 0))
            {
              ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[] { Integer.valueOf(paramAnonymousa.FAv.size()) });
              EmojiAddCustomDialogUI.f(EmojiAddCustomDialogUI.this);
            }
            else
            {
              EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this, null);
            }
          }
          else
          {
            EmojiAddCustomDialogUI.g(EmojiAddCustomDialogUI.this);
          }
        }
      }
    });
    AppMethodBeat.o(108847);
  }
  
  protected final void chI()
  {
    AppMethodBeat.i(108850);
    aq.aA(this.pIt);
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
    AppMethodBeat.o(108850);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108843);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    this.mContext = this;
    this.pIs = new c();
    this.ksR = getIntent().getStringExtra("extra_id");
    this.mScene = getIntent().getIntExtra("extra_scence", -1);
    this.pIm = getIntent().getStringExtra("extra_username");
    if ((getIntent().getBooleanExtra("extra_current", false)) && (this.pIm == null)) {
      this.pIm = u.aAm();
    }
    this.obY = getIntent().getBooleanExtra("extra_move_to_top", true);
    this.pIo = getIntent().getBooleanExtra("key_is_selfie", false);
    if (bt.isNullOrNil(this.ksR))
    {
      ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
      setResult(1);
      finish();
    }
    this.pIn = k.getEmojiStorageMgr().ILn.aUK(this.ksR);
    com.tencent.mm.kernel.g.ajB().gAO.a(423, this);
    aq.o(this.pIt, 300L);
    Object localObject = this.mContext;
    paramBundle = this.pIn;
    if (localObject == null)
    {
      ad.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(108843);
      return;
    }
    if (paramBundle == null)
    {
      ad.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(108843);
      return;
    }
    localObject = j.gkf;
    if (j.getKV().getBoolean("custom_full", false))
    {
      ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
      chI();
      chQ();
      com.tencent.mm.plugin.report.service.g.yhR.f(10431, new Object[] { Integer.valueOf(this.mScene), this.pIn.Lb(), this.pIn.field_designerID, this.pIn.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.pIn.field_size), this.pIm, this.pIn.field_activityid });
      AppMethodBeat.o(108843);
      return;
    }
    if ((paramBundle.field_catalog == EmojiInfo.OeT) || (bt.isNullOrNil(paramBundle.field_groupId)) || (bt.lQ(paramBundle.field_groupId, "capture")) || ((!bt.isNullOrNil(paramBundle.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abw(paramBundle.field_groupId))))
    {
      v(paramBundle);
      AppMethodBeat.o(108843);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.emoji.f.g(paramBundle.field_groupId, (byte)0);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramBundle, 0);
    AppMethodBeat.o(108843);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108844);
    com.tencent.mm.kernel.g.ajB().gAO.b(423, this);
    aq.aA(this.pIt);
    super.onDestroy();
    this.pIs.dead();
    if (this.pIp != null) {
      this.pIp.gqa = null;
    }
    AppMethodBeat.o(108844);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(108845);
    if (paramn.getType() == 423)
    {
      if (!(paramn instanceof com.tencent.mm.plugin.emoji.f.g))
      {
        AppMethodBeat.o(108845);
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
      if ((paramString != null) && (!bt.isNullOrNil(paramString.pFG)) && (this.pIn != null) && (!bt.isNullOrNil(this.pIn.field_groupId)) && (this.pIn.field_groupId.equalsIgnoreCase(paramString.pFG)))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          v(this.pIn);
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 4)
        {
          chI();
          if (this.mScene == 0)
          {
            paramString = this.pIn.field_groupId;
            if (!isFinishing())
            {
              this.pIr = com.tencent.mm.ui.base.h.c(this, getString(2131758208), "", true);
              this.pIr.b(2131755691, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(198749);
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(198749);
                }
              });
              this.pIr.a(2131758210, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(198750);
                  Object localObject = new Intent();
                  ((Intent)localObject).setClass(EmojiAddCustomDialogUI.this, EmojiStoreDetailUI.class);
                  ((Intent)localObject).putExtra("extra_id", paramString);
                  ((Intent)localObject).putExtra("preceding_scence", 20);
                  paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(198750);
                }
              });
            }
            AppMethodBeat.o(108845);
            return;
          }
          abY(getString(2131758208));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 8)
        {
          chI();
          abY(getString(2131758207));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 9)
        {
          chI();
          abY(getString(2131758206));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == -2)
        {
          chI();
          abY(getString(2131758209));
          AppMethodBeat.o(108845);
          return;
        }
        chI();
        abY(getString(2131758205));
        AppMethodBeat.o(108845);
        return;
      }
      ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(108845);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI
 * JD-Core Version:    0.7.0.1
 */