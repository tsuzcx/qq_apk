package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.Locale;
import org.json.JSONObject;

public final class u
  extends d
  implements Runnable
{
  private final int jIX;
  private final String jIY;
  private final c jIZ;
  private final c jJa;
  final c jJb;
  
  public u(int paramInt, String paramString)
  {
    super("LibIncrementalTestCase", Looper.getMainLooper());
    AppMethodBeat.i(44264);
    this.jIZ = new c()
    {
      public final void enter()
      {
        AppMethodBeat.i(44256);
        super.enter();
        ae.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
        Object localObject2 = ay.baP();
        if (bu.isNullOrNil((String)localObject2))
        {
          u.a(u.this, "!!MockLibInfo Path Error!!");
          AppMethodBeat.o(44256);
          return;
        }
        try
        {
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("version", u.a(u.this));
          localObject2 = new k((String)localObject2);
          ((k)localObject2).delete();
          ((k)localObject2).createNewFile();
          localObject1 = ((JSONObject)localObject1).toString().getBytes("UTF-8");
          int i = o.f(w.B(((k)localObject2).fTh()), (byte[])localObject1, localObject1.length);
          if (i != 0)
          {
            u.a(u.this, "MockLibInfo Write Error ".concat(String.valueOf(i)));
            AppMethodBeat.o(44256);
            return;
          }
        }
        catch (Exception localException)
        {
          u.a(u.this, "MockLibInfo Write Exception " + localException.getMessage());
          AppMethodBeat.o(44256);
          return;
        }
        u.a(u.this, u.b(u.this));
        AppMethodBeat.o(44256);
      }
    };
    this.jJa = new c()
    {
      public final void enter()
      {
        AppMethodBeat.i(44259);
        super.enter();
        ae.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
        ehp localehp = new ehp();
        localehp.url = String.format(Locale.US, "https://res.servicewechat.com/weapp/public/commlib/%d.wxapkg", new Object[] { Integer.valueOf(u.a(u.this)) });
        localehp.version = u.a(u.this);
        localehp.md5 = u.c(u.this);
        localehp.HAa = 1;
        j.aZu().a(localehp, new PInt());
        bj.a(localehp.url, localehp.version, new bj.a() {});
        AppMethodBeat.o(44259);
      }
    };
    this.jJb = new c()
    {
      public final void enter()
      {
        AppMethodBeat.i(44262);
        super.enter();
        ae.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
        au.fL(true);
        g.ajQ().gDv.a(1168, new f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(44261);
            if ((paramAnonymous2n != null) && ((paramAnonymous2n.getReqResp() instanceof com.tencent.mm.ak.b)))
            {
              paramAnonymous2String = (ehp)((com.tencent.mm.ak.b)paramAnonymous2n.getReqResp()).hQE.hQJ;
              paramAnonymous2Int1 = u.a(u.this);
              paramAnonymous2Int2 = paramAnonymous2String.version;
              paramAnonymous2String = new bj.a() {};
              bj.a(aw.B("@LibraryAppId", paramAnonymous2Int1, paramAnonymous2Int2), paramAnonymous2String);
            }
            g.ajQ().gDv.b(1168, this);
            AppMethodBeat.o(44261);
          }
        });
        AppMethodBeat.o(44262);
      }
    };
    this.jIX = paramInt;
    this.jIY = paramString;
    AppMethodBeat.o(44264);
  }
  
  public final void bao()
  {
    AppMethodBeat.i(44266);
    super.bao();
    ae.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
    AppMethodBeat.o(44266);
  }
  
  public final void run()
  {
    AppMethodBeat.i(44265);
    a(this.jIZ);
    a(this.jJa);
    a(this.jJb);
    b(this.jIZ);
    start();
    AppMethodBeat.o(44265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.u
 * JD-Core Version:    0.7.0.1
 */