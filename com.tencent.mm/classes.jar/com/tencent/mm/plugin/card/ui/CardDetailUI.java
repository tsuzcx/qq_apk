package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d.a;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.b.i.a;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CardDetailUI
  extends MMActivity
  implements com.tencent.mm.al.g, c.a, d.a, j.a, bh.a
{
  private View DR;
  private final String TAG;
  private float fjD;
  private float fjE;
  private b.a fjJ;
  private int fsv;
  private p ftP;
  private String gIj;
  private com.tencent.mm.modelgeo.d gXu;
  private Vibrator mHT;
  ap mHandler;
  private long mStartTime;
  private String nqb;
  private com.tencent.mm.plugin.card.base.b nqp;
  private ArrayList<rh> nqw;
  private boolean nrB;
  private String nrn;
  private int nvW;
  private boolean nwj;
  private int nxY;
  private String nxZ;
  private boolean nxf;
  private boolean nyA;
  private boolean nyB;
  private boolean nyC;
  private boolean nyD;
  private String nyE;
  private com.tencent.mm.plugin.card.b.i nyF;
  private String nya;
  private String nyb;
  e nyr;
  private String nys;
  private String nyt;
  private String nyu;
  private boolean nyv;
  private boolean nyw;
  private boolean nyx;
  private String nyy;
  private e.a nyz;
  
  public CardDetailUI()
  {
    AppMethodBeat.i(113213);
    this.TAG = "MicroMsg.CardDetailUI";
    this.ftP = null;
    this.nqb = "";
    this.nrn = "";
    this.nys = "";
    this.nyt = "";
    this.nyu = "";
    this.nxZ = "";
    this.nya = "";
    this.nyb = "";
    this.nrB = false;
    this.nyv = false;
    this.nyw = false;
    this.nyx = false;
    this.gIj = "";
    this.nyy = "";
    this.nwj = false;
    this.mHandler = new ap();
    this.fsv = 3;
    this.nxY = 0;
    this.nvW = -1;
    this.nyA = false;
    this.nyB = true;
    this.mStartTime = 0L;
    this.nyC = false;
    this.nxf = false;
    this.nyD = false;
    this.fjD = -85.0F;
    this.fjE = -1000.0F;
    this.nyE = "";
    this.nyF = new com.tencent.mm.plugin.card.b.i();
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(113199);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(113199);
          return true;
        }
        if ((CardDetailUI.a(CardDetailUI.this) == -85.0F) && (CardDetailUI.b(CardDetailUI.this) == -1000.0F))
        {
          CardDetailUI.a(CardDetailUI.this, paramAnonymousFloat2);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousFloat1);
          am.bJb().I(CardDetailUI.a(CardDetailUI.this), CardDetailUI.b(CardDetailUI.this));
        }
        com.tencent.mm.plugin.card.b.i locali = CardDetailUI.c(CardDetailUI.this);
        paramAnonymousFloat1 = CardDetailUI.b(CardDetailUI.this);
        paramAnonymousFloat2 = CardDetailUI.a(CardDetailUI.this);
        synchronized (locali.dah)
        {
          locali.fjD = paramAnonymousFloat2;
          locali.fjE = paramAnonymousFloat1;
          if (CardDetailUI.d(CardDetailUI.this))
          {
            CardDetailUI.e(CardDetailUI.this);
            CardDetailUI.f(CardDetailUI.this);
          }
          CardDetailUI.g(CardDetailUI.this);
          AppMethodBeat.o(113199);
          return false;
        }
      }
    };
    AppMethodBeat.o(113213);
  }
  
  /* Error */
  private void Qk(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 175
    //   4: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:nwj	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 91
    //   16: ldc 177
    //   18: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 175
    //   23: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 91
    //   31: ldc 185
    //   33: invokestatic 187	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:nwj	Z
    //   41: new 189	android/content/Intent
    //   44: dup
    //   45: aload_0
    //   46: ldc 191
    //   48: invokespecial 194	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   51: astore_2
    //   52: aload_2
    //   53: ldc 196
    //   55: aload_0
    //   56: getfield 198	com/tencent/mm/plugin/card/ui/CardDetailUI:nqp	Lcom/tencent/mm/plugin/card/base/b;
    //   59: invokeinterface 204 1 0
    //   64: invokevirtual 208	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   67: pop
    //   68: aload_2
    //   69: ldc 210
    //   71: aload_1
    //   72: invokevirtual 208	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   75: pop
    //   76: aload_2
    //   77: ldc 212
    //   79: aload_0
    //   80: getfield 198	com/tencent/mm/plugin/card/ui/CardDetailUI:nqp	Lcom/tencent/mm/plugin/card/base/b;
    //   83: invokeinterface 216 1 0
    //   88: getfield 221	com/tencent/mm/protocal/protobuf/ro:gHT	Ljava/lang/String;
    //   91: invokevirtual 208	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   94: pop
    //   95: aload_2
    //   96: ldc 223
    //   98: aload_0
    //   99: getfield 134	com/tencent/mm/plugin/card/ui/CardDetailUI:fsv	I
    //   102: invokevirtual 226	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   105: pop
    //   106: aload_2
    //   107: ldc 228
    //   109: iconst_0
    //   110: invokevirtual 226	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   113: pop
    //   114: new 230	com/tencent/mm/hellhoundlib/b/a
    //   117: dup
    //   118: invokespecial 231	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   121: aload_2
    //   122: invokevirtual 235	com/tencent/mm/hellhoundlib/b/a:bd	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   125: astore_1
    //   126: aload_0
    //   127: aload_1
    //   128: invokevirtual 239	com/tencent/mm/hellhoundlib/b/a:adn	()[Ljava/lang/Object;
    //   131: ldc 240
    //   133: ldc 242
    //   135: ldc 243
    //   137: ldc 245
    //   139: ldc 247
    //   141: ldc 249
    //   143: invokestatic 255	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: aload_1
    //   148: iconst_0
    //   149: invokevirtual 259	com/tencent/mm/hellhoundlib/b/a:lS	(I)Ljava/lang/Object;
    //   152: checkcast 189	android/content/Intent
    //   155: invokevirtual 261	com/tencent/mm/plugin/card/ui/CardDetailUI:startActivity	(Landroid/content/Intent;)V
    //   158: aload_0
    //   159: ldc 240
    //   161: ldc 242
    //   163: ldc 243
    //   165: ldc 245
    //   167: ldc 247
    //   169: ldc 249
    //   171: invokestatic 264	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   174: ldc 175
    //   176: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: goto -153 -> 26
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	CardDetailUI
    //   0	187	1	paramString	String
    //   51	71	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	26	182	finally
    //   29	179	182	finally
  }
  
  private void a(j.b paramb)
  {
    AppMethodBeat.i(113247);
    if (this.nyr.dkt)
    {
      ad.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
      AppMethodBeat.o(113247);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
    this.nyr.a(this.nyx, paramb, true);
    AppMethodBeat.o(113247);
  }
  
  private void bHs()
  {
    AppMethodBeat.i(113235);
    if (this.gXu == null) {
      this.gXu = com.tencent.mm.modelgeo.d.axT();
    }
    this.gXu.a(this.fjJ, true);
    AppMethodBeat.o(113235);
  }
  
  private void bHu()
  {
    AppMethodBeat.i(113236);
    if (this.gXu != null) {
      this.gXu.c(this.fjJ);
    }
    AppMethodBeat.o(113236);
  }
  
  private void bJG()
  {
    AppMethodBeat.i(113224);
    this.nyz.fsv = this.fsv;
    this.nyz.nvW = this.nvW;
    this.nyz.nqb = this.nqb;
    this.nyr.a(this.nqp, this.nyz, this.nqw);
    this.nyr.bJG();
    am.bJg().nqp = this.nqp;
    AppMethodBeat.o(113224);
  }
  
  private void bJQ()
  {
    AppMethodBeat.i(113237);
    this.gXu = com.tencent.mm.modelgeo.d.axT();
    bHs();
    AppMethodBeat.o(113237);
  }
  
  private void bKg()
  {
    AppMethodBeat.i(113219);
    com.tencent.mm.kernel.g.afA().gcy.a(1057, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1037, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1058, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1045, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1077, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1099, this);
    com.tencent.mm.kernel.g.afA().gcy.a(902, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1051, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1163, this);
    AppMethodBeat.o(113219);
  }
  
  private void bKh()
  {
    AppMethodBeat.i(113220);
    com.tencent.mm.kernel.g.afA().gcy.b(1057, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1037, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1058, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1045, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1077, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1099, this);
    com.tencent.mm.kernel.g.afA().gcy.b(902, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1051, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1163, this);
    AppMethodBeat.o(113220);
  }
  
  private void bKi()
  {
    AppMethodBeat.i(113222);
    this.nvW = this.fsv;
    this.nyz = new e.a();
    this.nyz.fsv = this.fsv;
    this.nyz.nvW = this.nvW;
    this.nyz.nqb = this.nqb;
    this.nyz.nys = this.nys;
    this.nyz.nyu = this.nyu;
    this.nyz.nyt = this.nyt;
    this.nyz.nxZ = this.nxZ;
    this.nyz.nya = this.nya;
    this.nyz.nrB = this.nrB;
    this.nyz.nzq = getIntent().getIntExtra("key_from_appbrand_type", 0);
    AppMethodBeat.o(113222);
  }
  
  private void bKj()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113223);
    if ((this.nyC) || (this.nqp == null))
    {
      AppMethodBeat.o(113223);
      return;
    }
    this.nyC = true;
    if (this.nrB)
    {
      localh = com.tencent.mm.plugin.report.service.h.vKh;
      j = this.nqp.bHV().lpz;
      str1 = this.nqp.bIa();
      str2 = this.nqp.bHZ();
      k = this.nvW;
      str3 = this.nys;
      if (this.nqp.bHT()) {}
      for (;;)
      {
        localh.f(11324, new Object[] { "ShareCardDetailUI", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
        AppMethodBeat.o(113223);
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
    int k = this.nqp.bHV().lpz;
    String str1 = this.nqp.bIa();
    String str2 = this.nqp.bHZ();
    int m = this.nvW;
    String str3 = this.nys;
    if (this.nqp.bHT()) {}
    for (i = j;; i = 0)
    {
      localh.f(11324, new Object[] { "CardDetailView", Integer.valueOf(k), str1, str2, Integer.valueOf(0), Integer.valueOf(m), str3, Integer.valueOf(i), "" });
      AppMethodBeat.o(113223);
      return;
    }
  }
  
  private void bKk()
  {
    AppMethodBeat.i(113229);
    Object localObject = new cxe();
    ((cxe)localObject).Epn = this.gIj;
    ((cxe)localObject).nsM = this.nyy;
    ad.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[] { this.gIj });
    localObject = new aa(this.nqb, this.fsv, this.nys, this.nyu, this.nxZ, this.nya, this.nxY, this.nyb, (cxe)localObject);
    com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject, 0);
    AppMethodBeat.o(113229);
  }
  
  private void bKl()
  {
    AppMethodBeat.i(113230);
    Object localObject;
    if (!TextUtils.isEmpty(this.nqp.bIa())) {
      localObject = this.nqp.bIa();
    }
    while ((this.nqp != null) && (this.nqp.bHV().CRJ == 1))
    {
      float f2 = this.fjD;
      float f3 = this.fjE;
      float f1;
      if (f2 != -85.0F)
      {
        f1 = f3;
        if (f3 != -1000.0F) {}
      }
      else
      {
        f2 = am.bJb().fjD;
        f1 = am.bJb().fjE;
      }
      localObject = new v((String)localObject, f1, f2, this.nqp.bHZ());
      com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject, 0);
      AppMethodBeat.o(113230);
      return;
      if (!TextUtils.isEmpty(this.nqb))
      {
        localObject = this.nqb;
      }
      else
      {
        ad.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
        AppMethodBeat.o(113230);
        return;
      }
    }
    if ((this.nqp != null) && (this.nqp.bHV().CRJ > 1))
    {
      if ((this.fjD != -85.0F) && (this.fjE != -1000.0F))
      {
        this.nyD = false;
        localObject = new v((String)localObject, this.fjE, this.fjD, this.nqp.bHZ());
        com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject, 0);
        AppMethodBeat.o(113230);
        return;
      }
      if (!this.nyD)
      {
        this.nyD = true;
        if (this.nxf)
        {
          bHs();
          AppMethodBeat.o(113230);
        }
      }
    }
    else if (this.nqp != null)
    {
      this.nqp.a(null);
      bJG();
      if (this.nqp.bHB())
      {
        localObject = am.bJd().QJ(this.nqb);
        if (localObject != null)
        {
          ((ShareCardInfo)localObject).a(null);
          am.bJd().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.nqb });
        }
        AppMethodBeat.o(113230);
        return;
      }
      localObject = am.bIV().Qt(this.nqb);
      if (localObject != null)
      {
        ((CardInfo)localObject).a(null);
        am.bIV().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.nqb });
      }
    }
    AppMethodBeat.o(113230);
  }
  
  private void bKm()
  {
    AppMethodBeat.i(113231);
    com.tencent.mm.plugin.card.sharecard.model.c localc = new com.tencent.mm.plugin.card.sharecard.model.c(this.nqb);
    com.tencent.mm.kernel.g.afA().gcy.a(localc, 0);
    AppMethodBeat.o(113231);
  }
  
  private void c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(113226);
    ad.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + paramInt1 + " errMsg = " + paramString1 + " ret_code:" + paramInt2 + " ret_msg:" + paramString2);
    if (paramInt2 == 10000)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = getString(2131756791);
      }
      this.nqp.bHW().status = 4;
      bJG();
    }
    for (;;)
    {
      com.tencent.mm.plugin.card.d.d.c(this, paramString1);
      AppMethodBeat.o(113226);
      return;
      if (paramInt2 == 10001)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756795);
        }
        this.nqp.bHW().status = 5;
        bJG();
      }
      else if (paramInt2 == 10002)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756946);
        }
      }
      else
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756789);
        }
      }
    }
  }
  
  private void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(113227);
    if (paramBoolean)
    {
      this.ftP = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(113227);
      return;
    }
    if ((this.ftP != null) && (this.ftP.isShowing()))
    {
      this.ftP.dismiss();
      this.ftP = null;
    }
    AppMethodBeat.o(113227);
  }
  
  private void iH(boolean paramBoolean)
  {
    AppMethodBeat.i(113228);
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.eJ(this.nyr.nzf, this.nyr.nze);
    }
    AppMethodBeat.o(113228);
  }
  
  private void y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(113233);
    Intent localIntent;
    if (paramInt == 1)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.nyE);
      localIntent.putExtra("key_card_id", this.nqb);
      localIntent.putExtra("key_finish_action", paramInt);
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.nvW == 7) || (this.nvW == 8) || (this.nvW == 16) || (this.nvW == 26)) && (this.fsv == 3))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.nyE);
      if (paramInt > 0)
      {
        localIntent.putExtra("key_card_id", this.nqb);
        localIntent.putExtra("key_finish_action", paramInt);
      }
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.nvW == 7) && (this.fsv == 7)) || ((this.nvW == 16) && (this.fsv == 16)) || ((this.nvW == 8) && (this.fsv == 8)) || ((this.nvW == 26) && (this.fsv == 26)))
    {
      setResult(0);
      if (paramBoolean)
      {
        finish();
        AppMethodBeat.o(113233);
      }
    }
    else if (paramBoolean)
    {
      finish();
    }
    AppMethodBeat.o(113233);
  }
  
  private void zb(int paramInt)
  {
    AppMethodBeat.i(113234);
    if ((this.nvW != 7) && (this.nvW != 16))
    {
      ad.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
      AppMethodBeat.o(113234);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new com.tencent.mm.plugin.card.model.e();
    ((com.tencent.mm.plugin.card.model.e)localObject).nrr = this.nqp.bIa();
    ((com.tencent.mm.plugin.card.model.e)localObject).dyd = this.nyu;
    ((com.tencent.mm.plugin.card.model.e)localObject).code = this.nyE;
    localLinkedList.add(localObject);
    localObject = new com.tencent.mm.g.a.b();
    ((com.tencent.mm.g.a.b)localObject).daM.bRZ = paramInt;
    if (paramInt == -1) {}
    for (((com.tencent.mm.g.a.b)localObject).daM.daN = com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.nvW);; ((com.tencent.mm.g.a.b)localObject).daM.daN = com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.nvW))
    {
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(113234);
      return;
    }
  }
  
  public final void P(String paramString, long paramLong)
  {
    AppMethodBeat.i(192629);
    paramString = this.nyr.nyP;
    if (paramString != null) {
      paramString.bMF();
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(16827, new Object[] { this.nqb, Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(192629);
  }
  
  public final void Qi(String paramString)
  {
    AppMethodBeat.i(113249);
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    }
    AppMethodBeat.o(113249);
  }
  
  public final void Ql(final String paramString)
  {
    AppMethodBeat.i(113243);
    if (!this.nyr.bKR())
    {
      ad.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
      AppMethodBeat.o(113243);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113212);
        CardDetailUI.c(CardDetailUI.this, paramString);
        AppMethodBeat.o(113212);
      }
    });
    AppMethodBeat.o(113243);
  }
  
  public final void Qo(String paramString)
  {
    AppMethodBeat.i(113246);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.nqb)))
    {
      ad.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113246);
      return;
    }
    this.nyv = false;
    AppMethodBeat.o(113246);
  }
  
  public final void b(String paramString, j.b paramb)
  {
    AppMethodBeat.i(113244);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.nqb)))
    {
      ad.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113244);
      return;
    }
    iF(false);
    ad.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
    ad.i("MicroMsg.CardDetailUI", "markSucc:" + paramb.nrf + " markCardId: " + paramb.nrg);
    this.nyw = false;
    if (paramb.nrf == 1)
    {
      if ((!TextUtils.isEmpty(paramb.nrg)) && (!this.nqp.bHZ().equals(paramb.nrg)))
      {
        ad.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
        if (this.nqp.bHB())
        {
          paramString = am.bJd().QJ(paramb.nrg);
          if (paramString != null)
          {
            this.nqp = paramString;
            this.nqb = paramb.nrg;
            bJG();
            am.bJg().b(this.nqp);
            ad.i("MicroMsg.CardDetailUI", "update the mCardInfo");
            this.nyv = true;
            a(paramb);
            AppMethodBeat.o(113244);
            return;
          }
          ad.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131756926));
          this.nyv = false;
          AppMethodBeat.o(113244);
        }
      }
      else
      {
        ad.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
        this.nyv = true;
        a(paramb);
        AppMethodBeat.o(113244);
      }
    }
    else
    {
      this.nyv = false;
      com.tencent.mm.plugin.card.d.d.c(this, getString(2131756927));
    }
    AppMethodBeat.o(113244);
  }
  
  public final void bIp()
  {
    AppMethodBeat.i(113248);
    ad.i("MicroMsg.CardDetailUI", "code change");
    if ((this.nyr.nyP instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.nyr.nyP).nDf = am.bJi().getCode();
      this.nyr.bJG();
    }
    AppMethodBeat.o(113248);
  }
  
  public final void bIu()
  {
    AppMethodBeat.i(113241);
    ad.i("MicroMsg.CardDetailUI", "onVibrate");
    this.mHT.vibrate(300L);
    AppMethodBeat.o(113241);
  }
  
  public final void bIv()
  {
    AppMethodBeat.i(113242);
    ad.i("MicroMsg.CardDetailUI", "onFinishUI");
    AppMethodBeat.o(113242);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113240);
    if (paramb == null)
    {
      ad.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if ((this.nqp == null) || (!this.nqp.bHZ().equals(paramb.bHZ())))
    {
      ad.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if (!this.nyr.bKR())
    {
      ad.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "onDataChange");
    this.nqp = paramb;
    this.nqb = this.nqp.bHZ();
    if ((this.nqp.bHP()) && (am.bJi().isEmpty())) {
      am.bJi().Qj(this.nqp.bHZ());
    }
    bJG();
    AppMethodBeat.o(113240);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113245);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.nqb)))
    {
      ad.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113245);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "onMarkFail()");
    this.nyv = false;
    this.nyw = false;
    iF(false);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(2131756926);
    }
    com.tencent.mm.plugin.card.d.d.c(this, paramString1);
    AppMethodBeat.o(113245);
  }
  
  public int getLayoutId()
  {
    return 2131493272;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113221);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113200);
        CardDetailUI.h(CardDetailUI.this);
        AppMethodBeat.o(113200);
        return true;
      }
    });
    this.mHT = ((Vibrator)getSystemService("vibrator"));
    this.DR = findViewById(2131297780);
    Object localObject2;
    if (this.nyr == null)
    {
      this.nyr = new e(this, getContentView());
      localObject1 = this.nyr;
      ((e)localObject1).nzb = new j(((e)localObject1).nqt);
      localObject2 = ((e)localObject1).nzb;
      ((j)localObject2).nvS = ((j)localObject2).nCW.getWindow().getAttributes().screenBrightness;
      if (((j)localObject2).iAs == null)
      {
        View localView = View.inflate(((j)localObject2).nCW, 2131493329, null);
        ((j)localObject2).iAu = localView.findViewById(2131303351);
        ((j)localObject2).iAt = ((ImageView)localView.findViewById(2131303350));
        ((j)localObject2).nCY = ((TextView)localView.findViewById(2131303353));
        ((j)localObject2).nCZ = ((TextView)localView.findViewById(2131303352));
        ((j)localObject2).nDa = localView.findViewById(2131303347);
        ((j)localObject2).nDb = ((ImageView)localView.findViewById(2131303346));
        ((j)localObject2).nDc = ((MMVerticalTextView)localView.findViewById(2131306295));
        ((j)localObject2).nDd = ((MMVerticalTextView)localView.findViewById(2131306296));
        localView.setOnClickListener(new j.2((j)localObject2));
        ((j)localObject2).iAs = new com.tencent.mm.ui.base.o(localView, -1, -1, true);
        ((j)localObject2).iAs.update();
        ((j)localObject2).iAs.setBackgroundDrawable(new ColorDrawable(16777215));
        ((j)localObject2).iAs.setOnDismissListener(new j.3((j)localObject2));
      }
      ((e)localObject1).nqt.setMMTitle("");
      ((e)localObject1).nqt.setActionbarColor(((e)localObject1).nqt.getResources().getColor(2131101179));
      ((e)localObject1).nzd = new com.tencent.mm.plugin.card.b.f(((e)localObject1).nqt);
      ((e)localObject1).nqt.mmSetOnActivityResultCallback((MMActivity.a)localObject1);
      com.tencent.mm.sdk.b.a.ESL.c(((e)localObject1).nzm);
      localObject1 = this.nyr;
      if (((e)localObject1).nyJ == null)
      {
        ((e)localObject1).nyJ = new x();
        ((e)localObject1).nyJ.a((n)localObject1);
      }
      if (((e)localObject1).nyL == null)
      {
        ((e)localObject1).nyL = new com.tencent.mm.plugin.card.ui.view.o();
        ((e)localObject1).nyL.a((n)localObject1);
      }
      if (((e)localObject1).nyM == null)
      {
        ((e)localObject1).nyM = new com.tencent.mm.plugin.card.ui.view.a();
        ((e)localObject1).nyM.a((n)localObject1);
      }
      ((e)localObject1).mListView = ((ListView)((e)localObject1).findViewById(2131297930));
      ((e)localObject1).nyQ = new m(((e)localObject1).nqt.getContext());
      ((e)localObject1).nyQ.nDJ = ((e)localObject1).iAw;
      ((e)localObject1).mListView.setAdapter(((e)localObject1).nyQ);
      ((e)localObject1).nyQ.notifyDataSetChanged();
      ((e)localObject1).mListView.setOnItemClickListener(new e.1((e)localObject1));
      ad.i("MicroMsg.CardDetailUIContoller", "initMenu");
      ((e)localObject1).nqt.addIconOptionMenu(0, 2131690603, new e.5((e)localObject1));
      ((e)localObject1).nyO = ((LinearLayout)((e)localObject1).findViewById(2131300735));
      ((e)localObject1).nyZ = new com.tencent.mm.plugin.card.ui.view.d();
      ((e)localObject1).nyZ.a((n)localObject1);
      ((e)localObject1).nzb.nqp = ((e)localObject1).nqp;
    }
    int i = getIntent().getIntExtra("key_from_scene", -1);
    ad.i("MicroMsg.CardDetailUI", "scene:%d", new Object[] { Integer.valueOf(i) });
    int j;
    if ((i == 2) || (i == 6) || (i == 5))
    {
      this.fsv = i;
      localObject1 = getIntent().getStringExtra("key_card_app_msg");
      localObject2 = com.tencent.mm.plugin.card.d.g.Rh((String)localObject1);
      if (localObject2 != null)
      {
        this.nqb = ((com.tencent.mm.plugin.card.model.d)localObject2).dyc;
        this.nys = ((com.tencent.mm.plugin.card.model.d)localObject2).nsI;
        this.nyu = ((com.tencent.mm.plugin.card.model.d)localObject2).dyd;
        j = ((com.tencent.mm.plugin.card.model.d)localObject2).nsL;
        ad.i("MicroMsg.CardDetailUI", "scene is " + i + ", isRecommend is " + j);
        if ((j == 1) && (i == 2)) {
          this.fsv = 23;
        }
        this.nyy = ((com.tencent.mm.plugin.card.model.d)localObject2).nsM;
        ad.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.nyy);
      }
      this.nyt = com.tencent.mm.plugin.card.d.g.Ri((String)localObject1);
      bKi();
      if (!TextUtils.isEmpty(this.nqb)) {
        break label1847;
      }
      ad.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
      y(true, -1);
    }
    for (;;)
    {
      this.nyr.a(this.nqp, this.nyz, this.nqw);
      this.nyr.nzj = new e.d()
      {
        public final void QO(String paramAnonymousString)
        {
          AppMethodBeat.i(113202);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousString);
          AppMethodBeat.o(113202);
        }
        
        public final void b(com.tencent.mm.plugin.card.base.b paramAnonymousb)
        {
          AppMethodBeat.i(113207);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousb);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousb.bHZ());
          CardDetailUI.m(CardDetailUI.this).nqb = CardDetailUI.n(CardDetailUI.this);
          AppMethodBeat.o(113207);
        }
        
        public final void bKm()
        {
          AppMethodBeat.i(113208);
          CardDetailUI.o(CardDetailUI.this);
          AppMethodBeat.o(113208);
        }
        
        public final void bKn()
        {
          AppMethodBeat.i(113201);
          CardDetailUI.i(CardDetailUI.this);
          AppMethodBeat.o(113201);
        }
        
        public final void bKo()
        {
          AppMethodBeat.i(113203);
          CardDetailUI.j(CardDetailUI.this);
          AppMethodBeat.o(113203);
        }
        
        public final void bKp()
        {
          AppMethodBeat.i(113204);
          CardDetailUI.k(CardDetailUI.this);
          AppMethodBeat.o(113204);
        }
        
        public final void bKq()
        {
          AppMethodBeat.i(113205);
          CardDetailUI.h(CardDetailUI.this);
          AppMethodBeat.o(113205);
        }
        
        public final void bKr()
        {
          AppMethodBeat.i(113206);
          CardDetailUI.l(CardDetailUI.this);
          AppMethodBeat.o(113206);
        }
        
        public final void bKs()
        {
          AppMethodBeat.i(113209);
          ad.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
          AppMethodBeat.o(113209);
        }
        
        public final void iI(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(113210);
          ad.i("MicroMsg.CardDetailUI", "doMark()");
          CardDetailUI.p(CardDetailUI.this);
          CardDetailUI.q(CardDetailUI.this);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousBoolean);
          if (CardDetailUI.r(CardDetailUI.this).bHO())
          {
            am.bJh().T(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.Rs(CardDetailUI.r(CardDetailUI.this).bIb()), 2);
            AppMethodBeat.o(113210);
            return;
          }
          am.bJh().T(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.Rs(CardDetailUI.r(CardDetailUI.this).bIb()), 1);
          AppMethodBeat.o(113210);
        }
      };
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
      ad.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      this.nxf = bool;
      if (this.nxf)
      {
        this.gXu = com.tencent.mm.modelgeo.d.axT();
        bHs();
      }
      AppMethodBeat.o(113221);
      return;
      if ((com.tencent.mm.plugin.card.d.l.zo(i)) || (i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 9) || (i == 12) || (i == 15) || (i == 17) || (i == 21))
      {
        this.fsv = i;
        this.nqb = getIntent().getStringExtra("key_card_id");
        this.nyu = getIntent().getStringExtra("key_card_ext");
        this.nrB = getIntent().getBooleanExtra("key_is_share_card", false);
        this.nxY = getIntent().getIntExtra("key_stastic_scene", 0);
        this.nyb = getIntent().getStringExtra("key_consumed_card_id");
        if ((i == 7) || (i == 16))
        {
          this.nxZ = getIntent().getStringExtra("src_username");
          this.nya = getIntent().getStringExtra("js_url");
          this.gIj = getIntent().getStringExtra("key_template_id");
          break;
        }
        if ((this.nrB) && (i == 3))
        {
          this.nrn = getIntent().getStringExtra("key_card_tp_id");
          this.nqb = com.tencent.mm.plugin.card.sharecard.a.b.eC(this.nqb, this.nrn);
          break;
        }
        if (i != 8) {
          break;
        }
        this.nyA = getIntent().getBooleanExtra("key_is_sms_add_card", false);
        break;
      }
      if ((i == 50) || (i == 27))
      {
        this.fsv = getIntent().getIntExtra("key_previous_scene", 50);
        if ((this.fsv != 26) && (this.fsv != 27)) {
          this.fsv = 3;
        }
        this.gIj = getIntent().getStringExtra("key_template_id");
        if (this.fsv == 27)
        {
          localObject1 = (com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info");
          if (localObject1 != null)
          {
            this.nqp = ((com.tencent.mm.plugin.card.base.b)localObject1);
            this.nqb = this.nqp.bHZ();
            bKi();
            bKl();
            if (this.nqp.bHP()) {
              am.bJi().Qj(this.nqp.bHZ());
            }
            bJG();
          }
          bKj();
          com.tencent.mm.plugin.card.d.l.bMK();
        }
        else
        {
          localObject1 = getIntent().getStringExtra("card_list");
          localObject2 = getIntent().getStringExtra("key_app_id");
          localObject1 = com.tencent.mm.plugin.card.d.k.v((String)localObject1, this.fsv, (String)localObject2);
          if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
          {
            ad.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
            y(true, -1);
          }
          for (;;)
          {
            bKi();
            break;
            iF(true);
            this.nqb = ((rp)((LinkedList)localObject1).get(0)).nrr;
            i = getIntent().getIntExtra("key_previous_scene", 51);
            localObject2 = new cxe();
            ((cxe)localObject2).Epn = this.gIj;
            ad.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.gIj });
            localObject1 = new t((LinkedList)localObject1, (cxe)localObject2, i, this.nqb);
            com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject1, 0);
          }
        }
      }
      else if (i == 51)
      {
        if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {}
        for (this.fsv = 26;; this.fsv = 3)
        {
          this.nqb = getIntent().getStringExtra("key_card_id");
          this.nqp = am.bJa().npS;
          if (this.nqp == null) {
            this.nqp = am.bIV().Qt(this.nqb);
          }
          bKi();
          if (this.nqp != null) {
            break label1695;
          }
          ad.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
          y(true, -1);
          break;
        }
        label1695:
        bKl();
        bJG();
        bKj();
        if (this.nqp.bHP()) {
          am.bJi().Qj(this.nqp.bHZ());
        }
      }
      else
      {
        if (i == 26)
        {
          this.fsv = i;
          this.nqb = getIntent().getStringExtra("key_card_id");
          this.nyu = getIntent().getStringExtra("key_card_ext");
          break;
        }
        this.fsv = i;
        localObject1 = getIntent().getStringExtra("key_card_app_msg");
        localObject2 = com.tencent.mm.plugin.card.d.g.Rh((String)localObject1);
        if (localObject2 != null)
        {
          this.nqb = ((com.tencent.mm.plugin.card.model.d)localObject2).dyc;
          this.nys = ((com.tencent.mm.plugin.card.model.d)localObject2).nsI;
          this.nyu = ((com.tencent.mm.plugin.card.model.d)localObject2).dyd;
        }
        this.nyt = com.tencent.mm.plugin.card.d.g.Ri((String)localObject1);
        break;
        label1847:
        if ((i == 2) || (i == 6) || ((i == 4) && (!this.nrB)) || (i == 5) || (i == 17) || (i == 21) || (i == 23)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (this.nqp != null)) {
            break label2072;
          }
          ad.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.nqb + " isShareCard is " + this.nrB);
          iF(true);
          this.DR.setVisibility(0);
          if (!this.nrB) {
            break label2065;
          }
          bKm();
          break;
          if (i == 15)
          {
            localObject1 = am.bJa().getValue("key_accept_card_info");
            if ((localObject1 != null) && ((localObject1 instanceof CardInfo)))
            {
              this.nqp = ((CardInfo)localObject1);
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
          else if (this.nrB)
          {
            this.nqp = am.bJd().QJ(this.nqb);
            i = 0;
          }
          else
          {
            this.nqp = am.bIV().Qt(this.nqb);
            i = 0;
          }
        }
        label2065:
        bKk();
      }
    }
    label2072:
    ad.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.nqb);
    Object localObject1 = this.nqp.bHY();
    if (localObject1 != null)
    {
      this.nqw = new ArrayList();
      this.nqw.add(localObject1);
    }
    bJG();
    if (this.nqp.bHP()) {
      am.bJi().Qj(this.nqp.bHZ());
    }
    if (this.nrB)
    {
      this.nyB = true;
      i = 1;
      label2179:
      if (i == 0) {
        break label2315;
      }
      ad.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.nqb + " isShareCard is " + this.nrB);
      if (!this.nrB) {
        break label2308;
      }
      bKm();
    }
    for (;;)
    {
      bKj();
      break;
      if ((int)(System.currentTimeMillis() / 1000L) - this.nqp.bIc() >= 86400L) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label2286;
        }
        this.nyB = true;
        i = 1;
        break;
      }
      label2286:
      if (!this.nqp.bHM()) {
        break label2179;
      }
      this.nyB = true;
      i = 1;
      break label2179;
      label2308:
      bKk();
      continue;
      label2315:
      bKl();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113214);
    super.onCreate(paramBundle);
    this.mStartTime = System.currentTimeMillis();
    bKg();
    paramBundle = am.bJg();
    AppCompatActivity localAppCompatActivity = getContext();
    com.tencent.mm.kernel.g.afA().gcy.a(910, paramBundle);
    am.bJc().a(paramBundle);
    com.tencent.mm.plugin.card.b.b localb = am.bIU();
    if (localb.nqa == null) {
      localb.nqa = new ArrayList();
    }
    localb.nqa.add(new WeakReference(paramBundle));
    paramBundle.avO = new WeakReference(localAppCompatActivity);
    am.bJg().a(this);
    am.bJh().a(this);
    paramBundle = am.bJi();
    com.tencent.mm.kernel.g.afA().gcy.a(577, paramBundle);
    paramBundle.nqc.clear();
    paramBundle.nqd = 0;
    am.bJi().a(this);
    initView();
    AppMethodBeat.o(113214);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113218);
    am.bJg().c(this);
    bKh();
    am.bJg().b(this);
    am.bJg().release();
    am.bJh().b(this);
    am.bJi().b(this);
    am.bJi().release();
    Object localObject1 = this.nyr;
    Object localObject2 = ((e)localObject1).nzd;
    ((com.tencent.mm.plugin.card.b.f)localObject2).nqp = null;
    ((com.tencent.mm.plugin.card.b.f)localObject2).nqu.clear();
    ((e)localObject1).nzd = null;
    localObject2 = ((e)localObject1).nzb;
    com.tencent.mm.plugin.card.d.l.T(((j)localObject2).nCX);
    int i = ((j)localObject2).nDe.size() - 1;
    while (i >= 0)
    {
      com.tencent.mm.plugin.card.d.l.T((Bitmap)((j)localObject2).nDe.remove(i));
      i -= 1;
    }
    ((j)localObject2).nDe.clear();
    if (((j)localObject2).iAs.isShowing()) {
      ((j)localObject2).iAs.dismiss();
    }
    ((j)localObject2).iAs = null;
    ((j)localObject2).bLm();
    ((j)localObject2).nCW = null;
    ((j)localObject2).nqp = null;
    ((e)localObject1).nzb = null;
    if (((e)localObject1).nyN != null) {
      ((e)localObject1).nyN.release();
    }
    ((e)localObject1).nqt.mmSetOnActivityResultCallback(null);
    com.tencent.mm.sdk.b.a.ESL.d(((e)localObject1).nzm);
    ((e)localObject1).nyJ.destroy();
    ((e)localObject1).nyM.destroy();
    ((e)localObject1).nyL.destroy();
    ((e)localObject1).nyZ.destroy();
    if (((e)localObject1).nza != null) {
      ((e)localObject1).nza.destroy();
    }
    if (((e)localObject1).nyS != null) {
      ((e)localObject1).nyS.destroy();
    }
    if (((e)localObject1).nyR != null) {
      ((e)localObject1).nyR.destroy();
    }
    if (((e)localObject1).nyT != null) {
      ((e)localObject1).nyT.destroy();
    }
    if (((e)localObject1).nyU != null) {
      ((e)localObject1).nyU.destroy();
    }
    if (((e)localObject1).nyV != null) {
      ((e)localObject1).nyV.destroy();
    }
    if (((e)localObject1).nyW != null) {
      ((e)localObject1).nyW.destroy();
    }
    if (((e)localObject1).nyX != null) {
      ((e)localObject1).nyX.destroy();
    }
    if (((e)localObject1).nyY != null) {
      ((e)localObject1).nyY.destroy();
    }
    if (((e)localObject1).nyP != null) {
      ((e)localObject1).nyP.destroy();
    }
    ((e)localObject1).nyI = null;
    localObject2 = am.bJl();
    if (((com.tencent.mm.plugin.card.b.g)localObject2).nqa != null)
    {
      i = 0;
      if (i < ((com.tencent.mm.plugin.card.b.g)localObject2).nqa.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.card.b.g)localObject2).nqa.get(i);
        if (localWeakReference == null) {
          break label748;
        }
        g.a locala = (g.a)localWeakReference.get();
        if ((locala == null) || (!locala.equals(localObject1))) {
          break label748;
        }
        ((com.tencent.mm.plugin.card.b.g)localObject2).nqa.remove(localWeakReference);
      }
    }
    am.bJl().release();
    this.mHT.cancel();
    bHu();
    long l = System.currentTimeMillis() - this.mStartTime;
    if (this.nqp != null)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.fsv), this.nqp.bIa(), this.nqp.bHZ(), Long.valueOf(l) });
      label611:
      if (((this.nyv) || (this.nyw)) && (this.nqp != null) && (this.nqp.bHB()))
      {
        if (!this.nqp.bHO()) {
          break label808;
        }
        am.bJh().cw(this.nqb, 2);
      }
      label667:
      localObject1 = this.nyF;
      ad.i("MicroMsg.CardLbsOrBluetooth", "uninit");
      if (((com.tencent.mm.plugin.card.b.i)localObject1).nqH != null)
      {
        localObject2 = ((com.tencent.mm.plugin.card.b.i)localObject1).nqH;
        if (((i.a)localObject2).jHB != null) {
          break label822;
        }
        ad.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.b.i)localObject1).nqH = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).bIC();
      ((com.tencent.mm.plugin.card.b.i)localObject1).nqM = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).nqA = null;
      super.onDestroy();
      AppMethodBeat.o(113218);
      return;
      label748:
      i += 1;
      break;
      com.tencent.mm.plugin.report.service.h.vKh.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.fsv), this.nqb, this.nqb, Long.valueOf(l) });
      break label611;
      label808:
      am.bJh().cw(this.nqb, 1);
      break label667;
      label822:
      aj.getContext().unregisterReceiver(((i.a)localObject2).jHB);
      ((i.a)localObject2).jHB = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113232);
    if (paramInt == 4)
    {
      ad.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
      y(false, -1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113232);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113216);
    bKh();
    super.onPause();
    this.nyr.dkt = true;
    am.bJg().a(this, false);
    bh.a(this, null);
    com.tencent.mm.plugin.card.b.i locali = this.nyF;
    if (locali.bIF())
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "stop");
      if (locali.nqH != null) {
        locali.nqH.bII();
      }
      locali.bIC();
      com.tencent.mm.kernel.g.afA().gcy.b(2574, locali);
    }
    AppMethodBeat.o(113216);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113238);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113238);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113238);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.nxf);
        if (!this.nxf)
        {
          this.nxf = true;
          bJQ();
        }
        AppMethodBeat.o(113238);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131757558), false, new CardDetailUI.4(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113215);
    super.onResume();
    bKg();
    if (this.gXu != null) {
      this.gXu.a(this.fjJ, true);
    }
    this.nyr.dkt = false;
    bh.a(this, this);
    am.bJg().a(this, true);
    Object localObject;
    int i;
    if (((this.nyv) || (this.nyw)) && (this.nqp.bHB()))
    {
      if (!this.nqp.bHO()) {
        break label224;
      }
      am.bJh().cw(this.nqb, 2);
      localObject = am.bJg();
      String str = this.nqb;
      localObject = (Boolean)((com.tencent.mm.plugin.card.b.d)localObject).nqo.get(str);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label208;
      }
      i = 1;
      if ((i == 0) || (TextUtils.isEmpty(am.bJg().nqr))) {
        break label213;
      }
      ad.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
      Ql(am.bJg().nqr);
      label171:
      this.nyr.nyP.d(com.tencent.mm.plugin.card.d.c.nJa);
    }
    for (;;)
    {
      if (this.nyF.csX) {
        this.nyF.start();
      }
      AppMethodBeat.o(113215);
      return;
      label208:
      i = 0;
      break;
      label213:
      ad.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
      break label171;
      label224:
      am.bJh().cw(this.nqb, 1);
      localObject = this.nyr.nyP;
      if (localObject != null) {
        ((com.tencent.mm.plugin.card.ui.view.g)localObject).d(com.tencent.mm.plugin.card.d.c.nJa);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(113225);
    ad.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      iF(false);
      this.DR.setVisibility(8);
      Object localObject;
      if ((paramn instanceof aa))
      {
        paramString = ((aa)paramn).ntw;
        if (TextUtils.isEmpty(paramString))
        {
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramn = this.nqp;
        localObject = new CardInfo();
        com.tencent.mm.plugin.card.d.f.a((CardInfo)localObject, paramString);
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bHZ()))
        {
          this.nqb = ((com.tencent.mm.plugin.card.base.b)localObject).bHZ();
          this.nqp = ((com.tencent.mm.plugin.card.base.b)localObject);
          bKl();
          if (this.fsv == 3)
          {
            if (paramn != null)
            {
              ((CardInfo)this.nqp).field_stickyAnnouncement = ((CardInfo)paramn).field_stickyAnnouncement;
              ((CardInfo)this.nqp).field_stickyEndTime = ((CardInfo)paramn).field_stickyEndTime;
              ((CardInfo)this.nqp).field_stickyIndex = ((CardInfo)paramn).field_stickyIndex;
              ((CardInfo)this.nqp).field_label_wording = ((CardInfo)paramn).field_label_wording;
              this.nqp.a(paramn.bHY());
            }
            if (!this.nyB) {
              break label405;
            }
            com.tencent.mm.plugin.card.d.l.h(this.nqp);
          }
        }
        for (;;)
        {
          bJG();
          bKj();
          if (this.nqp.bHP()) {
            am.bJi().Qj(this.nqp.bHZ());
          }
          this.nyF.a(this, this.nqb, this.nqp, this.fjD, this.fjE);
          AppMethodBeat.o(113225);
          return;
          if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bHZ())) || (this.nqb.equals(((com.tencent.mm.plugin.card.base.b)localObject).bIa()))) {
            break;
          }
          ad.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.nqb, ((com.tencent.mm.plugin.card.base.b)localObject).bIa() });
          AppMethodBeat.o(113225);
          return;
          label405:
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.o))
      {
        if (this.nvW == 26) {
          iF(false);
        }
        localObject = ((com.tencent.mm.plugin.card.model.o)paramn).ntw;
        paramInt1 = ((com.tencent.mm.plugin.card.model.o)paramn).ntx;
        paramn = ((com.tencent.mm.plugin.card.model.o)paramn).nty;
        if (paramInt1 != 0) {
          c(paramInt2, paramString, paramInt1, paramn);
        }
        while (TextUtils.isEmpty((CharSequence)localObject))
        {
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
          AppMethodBeat.o(113225);
          return;
          com.tencent.mm.ui.base.h.cf(this, getResources().getString(2131756802));
        }
        this.fsv = 3;
        if (this.nqp == null) {
          this.nqp = new CardInfo();
        }
        com.tencent.mm.plugin.card.d.f.a((CardInfo)this.nqp, (String)localObject);
        if (!TextUtils.isEmpty(this.nqp.bHZ())) {
          this.nqb = this.nqp.bHZ();
        }
        if (this.nyr.bKQ() == 1)
        {
          paramString = this.nyr;
          if (paramString.nzd != null)
          {
            paramString = paramString.nzd;
            if (paramString.nqv != null) {
              paramString.nqv.nrE = false;
            }
          }
        }
        if (this.nvW != 26)
        {
          bKl();
          bJG();
        }
        com.tencent.mm.plugin.card.d.l.bMK();
        paramString = this.nqp;
        if (paramString.bHC())
        {
          paramn = (Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FhB, Integer.valueOf(0));
          if ((paramn == null) || (paramn.intValue() != 1))
          {
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FhB, Integer.valueOf(1));
            if (!com.tencent.mm.plugin.card.d.l.bMN()) {
              break label908;
            }
            com.tencent.mm.plugin.card.d.d.c(this, 2131493349, 2131756799, paramString.bHV().nsJ);
          }
          label737:
          this.nyE = this.nqp.bIf();
          if ((this.nvW != 7) && (this.nvW != 16)) {
            break label930;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.nyE);
          setResult(-1, paramString);
          zb(-1);
        }
        for (;;)
        {
          if (this.nqp.bHP()) {
            am.bJi().Qj(this.nqp.bHZ());
          }
          this.nyF.a(this, this.nqb, this.nqp, this.fjD, this.fjE);
          AppMethodBeat.o(113225);
          return;
          paramn = (Integer)com.tencent.mm.kernel.g.afB().afk().get(282884, null);
          if ((paramn != null) && (paramn.intValue() == 1)) {
            break label737;
          }
          com.tencent.mm.kernel.g.afB().afk().set(282884, Integer.valueOf(1));
          break;
          label908:
          com.tencent.mm.plugin.card.d.d.c(this, 2131493348, 2131756798, paramString.bHV().nsJ);
          break label737;
          label930:
          if ((!this.nyA) && (this.nvW == 8)) {
            y(true, -1);
          } else if ((this.nvW == 26) && (paramInt1 == 0)) {
            y(true, -1);
          }
        }
      }
      if ((paramn instanceof v))
      {
        this.nqw = ((v)paramn).ntE;
        if ((this.nqp != null) && (this.nqw != null) && (this.nqw.size() > 0))
        {
          this.nqp.a((rh)this.nqw.get(0));
          bJG();
          if (this.nqp.bHB())
          {
            paramString = am.bJd().QJ(this.nqb);
            if (paramString != null)
            {
              paramString.a((rh)this.nqw.get(0));
              am.bJd().update(paramString, new String[] { this.nqb });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.bIV().Qt(this.nqb);
          if (paramString != null)
          {
            paramString.a((rh)this.nqw.get(0));
            am.bIV().update(paramString, new String[] { this.nqb });
          }
          AppMethodBeat.o(113225);
          return;
        }
        if ((this.nqp != null) && (this.nqw == null))
        {
          this.nqp.a(null);
          bJG();
          if (this.nqp.bHB())
          {
            paramString = am.bJd().QJ(this.nqb);
            if (paramString != null)
            {
              paramString.a(null);
              am.bJd().update(paramString, new String[] { this.nqb });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.bIV().Qt(this.nqb);
          if (paramString != null)
          {
            paramString.a(null);
            am.bIV().update(paramString, new String[] { this.nqb });
          }
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof af))
      {
        paramInt1 = ((af)paramn).ntx;
        localObject = ((af)paramn).nty;
        if (paramInt1 == 10000)
        {
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = getString(2131756852);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          AppMethodBeat.o(113225);
          return;
        }
        this.nyu = ((af)paramn).dyd;
        iH(true);
        paramString = this.nqp.bHW();
        paramString.status = 3;
        this.nqp.a(paramString);
        com.tencent.mm.plugin.card.d.l.h(this.nqp);
        bJG();
        if (this.nvW == 3)
        {
          y(true, 2);
          AppMethodBeat.o(113225);
          return;
        }
        if (this.nvW == 15)
        {
          paramString = new sn();
          com.tencent.mm.sdk.b.a.ESL.l(paramString);
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof r))
      {
        com.tencent.mm.ui.base.h.cf(this, getResources().getString(2131756828));
        am.bIU();
        com.tencent.mm.plugin.card.b.b.yP(4);
        y(true, 1);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof t))
      {
        paramString = (t)paramn;
        paramn = paramString.ntC;
        if ((paramn != null) && (paramn.size() > 0))
        {
          paramn = (com.tencent.mm.plugin.card.base.b)paramn.get(0);
          if ((paramn != null) && (!this.nqb.equals(paramString.cardId)))
          {
            ad.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.nqb, paramString.cardId });
            AppMethodBeat.o(113225);
            return;
          }
          this.nqp = paramn;
          if (this.nqp != null)
          {
            this.nqb = this.nqp.bHZ();
            bKl();
            if (this.nqp.bHP()) {
              am.bJi().Qj(this.nqp.bHZ());
            }
          }
          if (this.fsv == 26) {
            this.fsv = 3;
          }
          bJG();
        }
        bKj();
        com.tencent.mm.plugin.card.d.l.bMK();
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ntw;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ntx;
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).nty;
        if (paramInt1 != 0)
        {
          paramString = paramn;
          if (TextUtils.isEmpty(paramn)) {
            paramString = getString(2131756790);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          ad.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[] { paramString });
          AppMethodBeat.o(113225);
          return;
        }
        com.tencent.mm.ui.base.h.cf(this, getResources().getString(2131756794));
        if (TextUtils.isEmpty(paramString))
        {
          ad.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
          AppMethodBeat.o(113225);
          return;
        }
        this.fsv = 3;
        if (this.nqp == null)
        {
          this.nqp = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)this.nqp, paramString);
          paramn = (ShareCardInfo)this.nqp;
          if (!TextUtils.isEmpty(paramString)) {
            break label2149;
          }
          ad.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
          label1885:
          if (!TextUtils.isEmpty(this.nqp.bHZ())) {
            this.nqb = this.nqp.bHZ();
          }
          if (TextUtils.isEmpty(this.nqp.bIb())) {
            ((ShareCardInfo)this.nqp).field_from_username = u.aqG();
          }
          com.tencent.mm.plugin.card.d.l.a((ShareCardInfo)this.nqp);
          bKl();
          bJG();
          com.tencent.mm.plugin.card.d.l.bMM();
          am.bJc().onChange();
          this.nyE = this.nqp.bIf();
          if ((this.nvW != 7) && (this.nvW != 16)) {
            break label2241;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.nyE);
          setResult(-1, paramString);
          zb(-1);
        }
        for (;;)
        {
          for (;;)
          {
            paramString = (Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhz, Integer.valueOf(0));
            if ((paramString == null) || (paramString.intValue() != 1))
            {
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhz, Integer.valueOf(1));
              com.tencent.mm.plugin.card.d.d.c(this, 2131493351, 2131756987, "");
            }
            if (this.nqp.bHP()) {
              am.bJi().Qj(this.nqp.bHZ());
            }
            AppMethodBeat.o(113225);
            return;
            if (!(this.nqp instanceof CardInfo)) {
              break;
            }
            this.nqp = new ShareCardInfo();
            break;
            try
            {
              label2149:
              paramString = new JSONObject(paramString).optJSONArray("card_list");
              if (paramString == null) {
                break label1885;
              }
              paramn.nru = paramString.optJSONObject(0).optString("encrypt_code");
              ad.i("MicroMsg.CardInfoParser", "encrypt_code:" + paramn.nru);
            }
            catch (JSONException paramString)
            {
              ad.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
              ad.e("MicroMsg.CardInfoParser", paramString.getMessage());
            }
          }
          break label1885;
          label2241:
          if ((!this.nyA) && (this.nvW == 8)) {
            y(true, -1);
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.c))
      {
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.c)paramn).ntw;
        if (TextUtils.isEmpty(paramn))
        {
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramString = this.nqp;
        this.nqp = new ShareCardInfo();
        localObject = (ShareCardInfo)this.nqp;
        if (TextUtils.isEmpty(paramn))
        {
          ad.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
          if (paramString != null)
          {
            if (!TextUtils.isEmpty(paramString.bIb())) {
              ((ShareCardInfo)this.nqp).field_from_username = ((ShareCardInfo)paramString).field_from_username;
            }
            ((ShareCardInfo)this.nqp).field_app_id = ((ShareCardInfo)paramString).field_app_id;
            ((ShareCardInfo)this.nqp).field_consumer = ((ShareCardInfo)paramString).field_consumer;
            ((ShareCardInfo)this.nqp).field_share_time = ((ShareCardInfo)paramString).field_share_time;
            ((ShareCardInfo)this.nqp).field_updateTime = ((ShareCardInfo)paramString).field_updateTime;
            ((ShareCardInfo)this.nqp).field_begin_time = ((ShareCardInfo)paramString).field_begin_time;
            ((ShareCardInfo)this.nqp).field_end_time = ((ShareCardInfo)paramString).field_end_time;
            ((ShareCardInfo)this.nqp).field_block_mask = ((ShareCardInfo)paramString).field_block_mask;
            this.nqp.a(paramString.bHY());
            ((ShareCardInfo)this.nqp).field_categoryType = ((ShareCardInfo)paramString).field_categoryType;
            ((ShareCardInfo)this.nqp).field_itemIndex = ((ShareCardInfo)paramString).field_itemIndex;
            if (((ShareCardInfo)paramString).field_status != ((ShareCardInfo)this.nqp).field_status)
            {
              ad.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo)this.nqp).field_status);
              com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.nqp);
            }
          }
          if (!TextUtils.isEmpty(this.nqp.bHZ())) {
            this.nqb = this.nqp.bHZ();
          }
          bJG();
          bKl();
          bKj();
          if (this.fsv == 3)
          {
            if (!this.nyB) {
              break label2742;
            }
            com.tencent.mm.plugin.card.d.l.h(this.nqp);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (this.nqp.bHP()) {
              am.bJi().Qj(this.nqp.bHZ());
            }
            AppMethodBeat.o(113225);
            return;
            try
            {
              com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)localObject, new JSONObject(paramn));
            }
            catch (JSONException paramn)
            {
              ad.printErrStackTrace("MicroMsg.CardInfoParser", paramn, "", new Object[0]);
            }
          }
          break;
          label2742:
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.a))
      {
        if (((com.tencent.mm.plugin.card.sharecard.model.a)paramn).ntx != 0)
        {
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131756826));
          AppMethodBeat.o(113225);
          return;
        }
        ad.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.nqp.bHZ());
        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.nqp);
        com.tencent.mm.ui.base.h.cf(this, getResources().getString(2131756828));
        am.bJc().bJw();
        y(true, -1);
        AppMethodBeat.o(113225);
      }
    }
    else
    {
      ad.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " cmd:" + paramn.getType());
      iF(false);
      if (!(paramn instanceof af)) {
        break label3010;
      }
      iH(false);
      paramInt1 = ((af)paramn).ntx;
      paramn = ((af)paramn).nty;
      if (paramInt1 != 10000) {
        break label3067;
      }
      paramString = paramn;
      if (TextUtils.isEmpty(paramn)) {
        paramString = getString(2131756852);
      }
    }
    label3010:
    label3067:
    for (;;)
    {
      paramn = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramn = getString(2131757027);
      }
      Toast.makeText(getContext(), paramn, 0).show();
      AppMethodBeat.o(113225);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.card.model.o))
      {
        zb(0);
        c(paramInt2, paramString, ((com.tencent.mm.plugin.card.model.o)paramn).ntx, ((com.tencent.mm.plugin.card.model.o)paramn).nty);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof v))
      {
        AppMethodBeat.o(113225);
        return;
      }
    }
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113250);
    if ((this.nyr.nyP instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.nyr.nyP).nDf = am.bJi().getCode();
      this.nyr.bJG();
    }
    ad.i("MicroMsg.CardDetailUI", "code get success");
    AppMethodBeat.o(113250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI
 * JD-Core Version:    0.7.0.1
 */