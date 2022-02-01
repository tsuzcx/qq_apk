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
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.c.d.a;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dl.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
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
  implements com.tencent.mm.ak.f
{
  private ProgressDialog jbE;
  private String kwh;
  private Context mContext;
  private int mScene;
  private boolean ohM;
  private String pOR;
  private EmojiInfo pOS;
  private boolean pOT;
  private com.tencent.mm.emoji.c.d pOU;
  private com.tencent.mm.ui.widget.a.d pOV;
  private com.tencent.mm.ui.widget.a.d pOW;
  private c<com.tencent.mm.vending.e.a> pOX;
  private Runnable pOY;
  
  public EmojiAddCustomDialogUI()
  {
    AppMethodBeat.i(108842);
    this.pOY = new Runnable()
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
  
  private void acP(String paramString)
  {
    AppMethodBeat.i(108849);
    if (isFinishing())
    {
      AppMethodBeat.o(108849);
      return;
    }
    this.pOW = com.tencent.mm.ui.base.h.c(this, paramString, "", true);
    this.pOW.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(194867);
        EmojiAddCustomDialogUI.this.setResult(1);
        EmojiAddCustomDialogUI.this.finish();
        AppMethodBeat.o(194867);
      }
    });
    AppMethodBeat.o(108849);
  }
  
  private static void cjf()
  {
    AppMethodBeat.i(108846);
    Object localObject = new dl();
    ((dl)localObject).dpl.type = 1;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    if (!((dl)localObject).dpm.dpn)
    {
      localObject = k.getEmojiStorageMgr().JfX.fxE();
      if (localObject != null)
      {
        Iterator localIterator = ((dfo)localObject).HMN.iterator();
        while (localIterator.hasNext())
        {
          dfp localdfp = (dfp)localIterator.next();
          if (localdfp.ProductID.equals(String.valueOf(EmojiGroupInfo.OzS))) {
            localdfp.FUF = 0;
          }
        }
      }
      k.getEmojiStorageMgr().JfX.a((dfo)localObject);
      com.tencent.mm.ca.a.flq();
      localObject = com.tencent.mm.ca.a.Ipp;
      a.b.aRa(String.valueOf(EmojiGroupInfo.OzS));
    }
    AppMethodBeat.o(108846);
  }
  
  private void cjg()
  {
    AppMethodBeat.i(108848);
    if (isFinishing())
    {
      AppMethodBeat.o(108848);
      return;
    }
    this.pOV = com.tencent.mm.ui.base.h.a(this.mContext, 2131758413, 2131755726, 2131758337, 2131755691, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(194877);
        Object localObject = new Intent();
        com.tencent.mm.plugin.report.service.g.yxI.f(11596, new Object[] { Integer.valueOf(3) });
        ((Intent)localObject).setClass(EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this), EmojiCustomUI.class);
        ((Intent)localObject).putExtra("key_emoji_panel_type", 0);
        paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(194877);
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
    if (this.pOV != null) {
      this.pOV.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(194878);
          EmojiAddCustomDialogUI.this.setResult(3);
          EmojiAddCustomDialogUI.this.finish();
          AppMethodBeat.o(194878);
        }
      });
    }
    AppMethodBeat.o(108848);
  }
  
  private void v(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108847);
    ae.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmojiInfo.Lj());
    paramEmojiInfo = new com.tencent.mm.emoji.sync.a(0, localArrayList);
    paramEmojiInfo.hQs = true;
    paramEmojiInfo.aET().a(this.pOX).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(a.a<hy> paramAnonymousa)
      {
        AppMethodBeat.i(194872);
        int i = paramAnonymousa.errType;
        int j = paramAnonymousa.errCode;
        if (j == -434)
        {
          ae.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
          paramAnonymousa = j.gmz;
          j.dp(true);
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKR, Boolean.TRUE);
          EmojiAddCustomDialogUI.this.ciY();
          EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this);
          com.tencent.mm.plugin.report.service.g.yxI.f(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.c(EmojiAddCustomDialogUI.this)), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).Lj(), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_designerID, EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_size), EmojiAddCustomDialogUI.e(EmojiAddCustomDialogUI.this), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_activityid });
        }
        for (;;)
        {
          paramAnonymousa = LEs;
          AppMethodBeat.o(194872);
          return paramAnonymousa;
          if ((i == 0) && (j == 0))
          {
            ae.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
            paramAnonymousa = (hy)paramAnonymousa.hQv;
            if ((paramAnonymousa != null) && (paramAnonymousa.FSR != null) && (paramAnonymousa.FSR.size() > 0))
            {
              ae.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[] { Integer.valueOf(paramAnonymousa.FSR.size()) });
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
  
  protected final void ciY()
  {
    AppMethodBeat.i(108850);
    ar.ay(this.pOY);
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
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
    this.pOX = new c();
    this.kwh = getIntent().getStringExtra("extra_id");
    this.mScene = getIntent().getIntExtra("extra_scence", -1);
    this.pOR = getIntent().getStringExtra("extra_username");
    if ((getIntent().getBooleanExtra("extra_current", false)) && (this.pOR == null)) {
      this.pOR = v.aAC();
    }
    this.ohM = getIntent().getBooleanExtra("extra_move_to_top", true);
    this.pOT = getIntent().getBooleanExtra("key_is_selfie", false);
    if (bu.isNullOrNil(this.kwh))
    {
      ae.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
      setResult(1);
      finish();
    }
    this.pOS = k.getEmojiStorageMgr().JfU.aWl(this.kwh);
    com.tencent.mm.kernel.g.ajQ().gDv.a(423, this);
    ar.o(this.pOY, 300L);
    Object localObject = this.mContext;
    paramBundle = this.pOS;
    if (localObject == null)
    {
      ae.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(108843);
      return;
    }
    if (paramBundle == null)
    {
      ae.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(108843);
      return;
    }
    localObject = j.gmz;
    if (j.getKV().getBoolean("custom_full", false))
    {
      ae.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
      ciY();
      cjg();
      com.tencent.mm.plugin.report.service.g.yxI.f(10431, new Object[] { Integer.valueOf(this.mScene), this.pOS.Lj(), this.pOS.field_designerID, this.pOS.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.pOS.field_size), this.pOR, this.pOS.field_activityid });
      AppMethodBeat.o(108843);
      return;
    }
    if ((paramBundle.field_catalog == EmojiInfo.OAa) || (bu.isNullOrNil(paramBundle.field_groupId)) || (bu.lX(paramBundle.field_groupId, "capture")) || ((!bu.isNullOrNil(paramBundle.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acn(paramBundle.field_groupId))))
    {
      v(paramBundle);
      AppMethodBeat.o(108843);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.emoji.f.g(paramBundle.field_groupId, (byte)0);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramBundle, 0);
    AppMethodBeat.o(108843);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108844);
    com.tencent.mm.kernel.g.ajQ().gDv.b(423, this);
    ar.ay(this.pOY);
    super.onDestroy();
    this.pOX.dead();
    if (this.pOU != null) {
      this.pOU.gsv = null;
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
      if ((paramString != null) && (!bu.isNullOrNil(paramString.pMk)) && (this.pOS != null) && (!bu.isNullOrNil(this.pOS.field_groupId)) && (this.pOS.field_groupId.equalsIgnoreCase(paramString.pMk)))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          v(this.pOS);
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 4)
        {
          ciY();
          if (this.mScene == 0)
          {
            paramString = this.pOS.field_groupId;
            if (!isFinishing())
            {
              this.pOW = com.tencent.mm.ui.base.h.c(this, getString(2131758208), "", true);
              this.pOW.b(2131755691, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(194868);
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(194868);
                }
              });
              this.pOW.a(2131758210, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(194869);
                  Object localObject = new Intent();
                  ((Intent)localObject).setClass(EmojiAddCustomDialogUI.this, EmojiStoreDetailUI.class);
                  ((Intent)localObject).putExtra("extra_id", paramString);
                  ((Intent)localObject).putExtra("preceding_scence", 20);
                  paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(194869);
                }
              });
            }
            AppMethodBeat.o(108845);
            return;
          }
          acP(getString(2131758208));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 8)
        {
          ciY();
          acP(getString(2131758207));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 9)
        {
          ciY();
          acP(getString(2131758206));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == -2)
        {
          ciY();
          acP(getString(2131758209));
          AppMethodBeat.o(108845);
          return;
        }
        ciY();
        acP(getString(2131758205));
        AppMethodBeat.o(108845);
        return;
      }
      ae.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(108845);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI
 * JD-Core Version:    0.7.0.1
 */