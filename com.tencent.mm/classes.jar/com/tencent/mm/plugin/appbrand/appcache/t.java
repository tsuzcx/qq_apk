package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.Locale;
import org.json.JSONObject;

public final class t
  extends d
  implements Runnable
{
  private final int jFX;
  private final String jFY;
  private final c jFZ;
  private final c jGa;
  final c jGb;
  
  public t(int paramInt, String paramString)
  {
    super("LibIncrementalTestCase", Looper.getMainLooper());
    AppMethodBeat.i(44264);
    this.jFZ = new c()
    {
      public final void enter()
      {
        AppMethodBeat.i(44256);
        super.enter();
        ad.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
        Object localObject2 = ax.baq();
        if (bt.isNullOrNil((String)localObject2))
        {
          t.a(t.this, "!!MockLibInfo Path Error!!");
          AppMethodBeat.o(44256);
          return;
        }
        try
        {
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("version", t.a(t.this));
          localObject2 = new e((String)localObject2);
          ((e)localObject2).delete();
          ((e)localObject2).createNewFile();
          localObject1 = ((JSONObject)localObject1).toString().getBytes("UTF-8");
          int i = i.f(com.tencent.mm.vfs.q.B(((e)localObject2).fOK()), (byte[])localObject1, localObject1.length);
          if (i != 0)
          {
            t.a(t.this, "MockLibInfo Write Error ".concat(String.valueOf(i)));
            AppMethodBeat.o(44256);
            return;
          }
        }
        catch (Exception localException)
        {
          t.a(t.this, "MockLibInfo Write Exception " + localException.getMessage());
          AppMethodBeat.o(44256);
          return;
        }
        t.a(t.this, t.b(t.this));
        AppMethodBeat.o(44256);
      }
    };
    this.jGa = new c()
    {
      public final void enter()
      {
        AppMethodBeat.i(44259);
        super.enter();
        ad.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
        efy localefy = new efy();
        localefy.url = String.format(Locale.US, "https://res.servicewechat.com/weapp/public/commlib/%d.wxapkg", new Object[] { Integer.valueOf(t.a(t.this)) });
        localefy.version = t.a(t.this);
        localefy.md5 = t.c(t.this);
        localefy.HgA = 1;
        j.aYX().a(localefy, new PInt());
        bi.a(localefy.url, localefy.version, new bi.a() {});
        AppMethodBeat.o(44259);
      }
    };
    this.jGb = new c()
    {
      public final void enter()
      {
        AppMethodBeat.i(44262);
        super.enter();
        ad.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
        at.fM(true);
        g.ajB().gAO.a(1168, new f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(44261);
            if ((paramAnonymous2n != null) && ((paramAnonymous2n.getReqResp() instanceof com.tencent.mm.al.b)))
            {
              paramAnonymous2String = (efy)((com.tencent.mm.al.b)paramAnonymous2n.getReqResp()).hNL.hNQ;
              paramAnonymous2Int1 = t.a(t.this);
              paramAnonymous2Int2 = paramAnonymous2String.version;
              paramAnonymous2String = new bi.a() {};
              bi.a(av.B("@LibraryAppId", paramAnonymous2Int1, paramAnonymous2Int2), paramAnonymous2String);
            }
            g.ajB().gAO.b(1168, this);
            AppMethodBeat.o(44261);
          }
        });
        AppMethodBeat.o(44262);
      }
    };
    this.jFX = paramInt;
    this.jFY = paramString;
    AppMethodBeat.o(44264);
  }
  
  public final void aZP()
  {
    AppMethodBeat.i(44266);
    super.aZP();
    ad.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
    AppMethodBeat.o(44266);
  }
  
  public final void run()
  {
    AppMethodBeat.i(44265);
    a(this.jFZ);
    a(this.jGa);
    a(this.jGb);
    b(this.jFZ);
    start();
    AppMethodBeat.o(44265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t
 * JD-Core Version:    0.7.0.1
 */