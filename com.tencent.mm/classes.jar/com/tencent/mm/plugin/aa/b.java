package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.a.abl;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.ch;
import com.tencent.mm.f.a.rp;
import com.tencent.mm.f.a.rq;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.e;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d.a;
import java.util.HashMap;

public class b
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private IListener<rq> mII;
  private IListener<rp> mIJ;
  private IListener<cg> mIK;
  private IListener<ch> mIL;
  private t mIM;
  IListener<abl> mIN;
  private d mIO;
  private com.tencent.mm.plugin.aa.model.a.b mIP;
  
  static
  {
    AppMethodBeat.i(63318);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("AARecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("AAPayRecord".hashCode()), new b.8());
    AppMethodBeat.o(63318);
  }
  
  public b()
  {
    AppMethodBeat.i(63312);
    this.mII = new b.1(this);
    this.mIJ = new IListener() {};
    this.mIK = new IListener() {};
    this.mIL = new IListener() {};
    this.mIM = new b.5(this);
    this.mIN = new IListener() {};
    AppMethodBeat.o(63312);
  }
  
  private static b bwg()
  {
    AppMethodBeat.i(63313);
    b localb = (b)y.as(b.class);
    AppMethodBeat.o(63313);
    return localb;
  }
  
  public static d bwh()
  {
    AppMethodBeat.i(63314);
    if (bwg().mIO == null)
    {
      localObject = bwg();
      h.aHH();
      ((b)localObject).mIO = new d(h.aHG().kcF);
    }
    Object localObject = bwg().mIO;
    AppMethodBeat.o(63314);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.aa.model.a.b bwi()
  {
    AppMethodBeat.i(63315);
    if (bwg().mIP == null)
    {
      localObject = bwg();
      h.aHH();
      ((b)localObject).mIP = new com.tencent.mm.plugin.aa.model.a.b(h.aHG().kcF);
    }
    Object localObject = bwg().mIP;
    AppMethodBeat.o(63315);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(63316);
    EventCenter.instance.addListener(this.mII);
    EventCenter.instance.addListener(this.mIJ);
    EventCenter.instance.addListener(this.mIK);
    EventCenter.instance.addListener(this.mIL);
    EventCenter.instance.addListener(this.mIN);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("paymsg", this.mIM);
    e.a(new com.tencent.mm.plugin.messenger.foundation.a.c()
    {
      public final void a(h.a paramAnonymousa, ca paramAnonymousca, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(184836);
        if ((!paramAnonymousBoolean) && (paramAnonymousca != null) && (!Util.isNullOrNil(paramAnonymousca.field_content))) {
          if (!ar.isDarkMode()) {
            break label73;
          }
        }
        label73:
        for (paramAnonymousa = "#7D90A9";; paramAnonymousa = "#576B95")
        {
          paramAnonymousca.setContent(paramAnonymousca.field_content.replace("color=\"#037AFF\"", "color=\"" + paramAnonymousa + "\""));
          AppMethodBeat.o(184836);
          return;
        }
      }
      
      public final void b(h.a paramAnonymousa, ca paramAnonymousca, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(63316);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63317);
    EventCenter.instance.removeListener(this.mII);
    EventCenter.instance.removeListener(this.mIJ);
    EventCenter.instance.removeListener(this.mIK);
    EventCenter.instance.removeListener(this.mIL);
    EventCenter.instance.removeListener(this.mIN);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("paymsg", this.mIM);
    AppMethodBeat.o(63317);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b
 * JD-Core Version:    0.7.0.1
 */