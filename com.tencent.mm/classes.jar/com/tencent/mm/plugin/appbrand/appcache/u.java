package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.fch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Locale;
import org.json.JSONObject;

public final class u
  extends StateMachine
  implements Runnable
{
  private static final String kKT;
  private final int kKU;
  private final String kKV;
  private final State kKW;
  private final State kKX;
  private final State kKY;
  
  static
  {
    AppMethodBeat.i(226354);
    kKT = "https://" + WeChatHosts.domainString(2131761735) + "/weapp/public/commlib/%d.wxapkg";
    AppMethodBeat.o(226354);
  }
  
  public u(int paramInt, String paramString)
  {
    super("LibIncrementalTestCase", Looper.getMainLooper());
    AppMethodBeat.i(44264);
    this.kKW = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(44256);
        super.enter();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
        Object localObject2 = ay.bwd();
        if (Util.isNullOrNil((String)localObject2))
        {
          u.a(u.this, "!!MockLibInfo Path Error!!");
          AppMethodBeat.o(44256);
          return;
        }
        try
        {
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("version", u.a(u.this));
          localObject2 = new o((String)localObject2);
          ((o)localObject2).delete();
          ((o)localObject2).createNewFile();
          localObject1 = ((JSONObject)localObject1).toString().getBytes("UTF-8");
          int i = s.f(aa.z(((o)localObject2).her()), (byte[])localObject1, localObject1.length);
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
    this.kKX = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(44259);
        super.enter();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
        fch localfch = new fch();
        localfch.url = String.format(Locale.US, u.kKT, new Object[] { Integer.valueOf(u.a(u.this)) });
        localfch.version = u.a(u.this);
        localfch.md5 = u.c(u.this);
        localfch.MKJ = 1;
        n.buL().a(localfch, new PInt());
        bj.a(localfch.url, localfch.version, new bj.a() {});
        AppMethodBeat.o(44259);
      }
    };
    this.kKY = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(44262);
        super.enter();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
        au.gH(true);
        g.aAg().hqi.a(1168, new i()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
          {
            AppMethodBeat.i(44261);
            if ((paramAnonymous2q != null) && ((paramAnonymous2q.getReqResp() instanceof d)))
            {
              paramAnonymous2String = (fch)((d)paramAnonymous2q.getReqResp()).iLL.iLR;
              paramAnonymous2Int1 = u.a(u.this);
              paramAnonymous2Int2 = paramAnonymous2String.version;
              paramAnonymous2String = new bj.a() {};
              bj.a(aw.B("@LibraryAppId", paramAnonymous2Int1, paramAnonymous2Int2), paramAnonymous2String);
            }
            g.aAg().hqi.b(1168, this);
            AppMethodBeat.o(44261);
          }
        });
        AppMethodBeat.o(44262);
      }
    };
    this.kKU = paramInt;
    this.kKV = paramString;
    AppMethodBeat.o(44264);
  }
  
  public final void onQuitting()
  {
    AppMethodBeat.i(44266);
    super.onQuitting();
    Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
    AppMethodBeat.o(44266);
  }
  
  public final void run()
  {
    AppMethodBeat.i(44265);
    addState(this.kKW);
    addState(this.kKX);
    addState(this.kKY);
    setInitialState(this.kKW);
    start();
    AppMethodBeat.o(44265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.u
 * JD-Core Version:    0.7.0.1
 */