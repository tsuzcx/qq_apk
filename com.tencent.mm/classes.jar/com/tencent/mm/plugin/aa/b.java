package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.yz;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.vending.g.d.a;
import java.util.HashMap;

public class b
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c<pw> iUB;
  private com.tencent.mm.sdk.b.c<pv> iUC;
  private com.tencent.mm.sdk.b.c<ca> iUD;
  private com.tencent.mm.sdk.b.c<cb> iUE;
  private q iUF;
  com.tencent.mm.sdk.b.c<yz> iUG;
  private d iUH;
  private com.tencent.mm.plugin.aa.model.a.b iUI;
  
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
    this.iUB = new b.1(this);
    this.iUC = new com.tencent.mm.sdk.b.c() {};
    this.iUD = new com.tencent.mm.sdk.b.c() {};
    this.iUE = new com.tencent.mm.sdk.b.c() {};
    this.iUF = new b.5(this);
    this.iUG = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(63312);
  }
  
  private static b aRu()
  {
    AppMethodBeat.i(63313);
    b localb = (b)u.ap(b.class);
    AppMethodBeat.o(63313);
    return localb;
  }
  
  public static d aRv()
  {
    AppMethodBeat.i(63314);
    if (aRu().iUH == null)
    {
      localObject = aRu();
      g.ajS();
      ((b)localObject).iUH = new d(g.ajR().gDX);
    }
    Object localObject = aRu().iUH;
    AppMethodBeat.o(63314);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.aa.model.a.b aRw()
  {
    AppMethodBeat.i(63315);
    if (aRu().iUI == null)
    {
      localObject = aRu();
      g.ajS();
      ((b)localObject).iUI = new com.tencent.mm.plugin.aa.model.a.b(g.ajR().gDX);
    }
    Object localObject = aRu().iUI;
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
    com.tencent.mm.sdk.b.a.IvT.c(this.iUB);
    com.tencent.mm.sdk.b.a.IvT.c(this.iUC);
    com.tencent.mm.sdk.b.a.IvT.c(this.iUD);
    com.tencent.mm.sdk.b.a.IvT.c(this.iUE);
    com.tencent.mm.sdk.b.a.IvT.c(this.iUG);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("paymsg", this.iUF);
    com.tencent.mm.model.e.a(new com.tencent.mm.plugin.messenger.foundation.a.a()
    {
      public final void a(e.a paramAnonymousa, bv paramAnonymousbv, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(184836);
        if ((!paramAnonymousBoolean) && (paramAnonymousbv != null) && (!bu.isNullOrNil(paramAnonymousbv.field_content))) {
          if (!al.isDarkMode()) {
            break label73;
          }
        }
        label73:
        for (paramAnonymousa = "#7D90A9";; paramAnonymousa = "#576B95")
        {
          paramAnonymousbv.setContent(paramAnonymousbv.field_content.replace("color=\"#037AFF\"", "color=\"" + paramAnonymousa + "\""));
          AppMethodBeat.o(184836);
          return;
        }
      }
      
      public final void b(e.a paramAnonymousa, bv paramAnonymousbv, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(63316);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63317);
    com.tencent.mm.sdk.b.a.IvT.d(this.iUB);
    com.tencent.mm.sdk.b.a.IvT.d(this.iUC);
    com.tencent.mm.sdk.b.a.IvT.d(this.iUD);
    com.tencent.mm.sdk.b.a.IvT.d(this.iUE);
    com.tencent.mm.sdk.b.a.IvT.d(this.iUG);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("paymsg", this.iUF);
    AppMethodBeat.o(63317);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b
 * JD-Core Version:    0.7.0.1
 */