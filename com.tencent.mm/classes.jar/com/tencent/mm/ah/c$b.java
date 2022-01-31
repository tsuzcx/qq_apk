package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.e;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class c$b
  implements az.a
{
  public boolean bak = false;
  public h frE = null;
  public byte[] frF = null;
  
  public c$b(c paramc, h paramh)
  {
    this.frE = paramh;
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(77856);
    if (this.frE == null)
    {
      AppMethodBeat.o(77856);
      return false;
    }
    if (!at.isNetworkConnected(ah.getContext()))
    {
      ab.w("MicroMsg.HttpGetAvatar", "[tomys] network is unavailable, skip rest loading logic.");
      ab.dsI();
    }
    Object localObject17 = this.frE.acY();
    boolean bool1 = ((com.tencent.mm.plugin.emoji.b.c)g.E(com.tencent.mm.plugin.emoji.b.c.class)).bke();
    boolean bool2 = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVI, false);
    Object localObject1;
    label143:
    Object localObject3;
    int i;
    Object localObject8;
    Object localObject10;
    Object localObject12;
    Object localObject5;
    Object localObject2;
    Object localObject18;
    Object localObject19;
    Object localObject20;
    byte[] arrayOfByte4;
    byte[] arrayOfByte1;
    Object localObject13;
    Object localObject6;
    Object localObject14;
    Object localObject9;
    Object localObject15;
    Object localObject11;
    Object localObject16;
    if ((bool1) && (bool2))
    {
      ab.i("MicroMsg.HttpGetAvatar", "HttpGetAvatar: get hevc");
      if (((String)localObject17).contains("?"))
      {
        localObject1 = (String)localObject17 + "&tp=wxpic";
        com.tencent.mm.plugin.report.service.h.qsU.cT(138, 50);
        localObject17 = localObject1;
        localObject3 = "";
        if (g.RJ().QU())
        {
          i = d.whH;
          g.RJ();
          localObject3 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", new Object[] { Integer.valueOf(i), p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(at.getNetTypeForStat(ah.getContext())), Integer.valueOf(at.getStrength(ah.getContext())) });
        }
        ab.d("MicroMsg.HttpGetAvatar", "dkreferer dkavatar user: %s referer: %s", new Object[] { this.frE.getUsername(), localObject3 });
        this.frF = null;
        localObject8 = null;
        localObject10 = null;
        localObject12 = null;
        localObject5 = null;
        localObject2 = new ByteArrayOutputStream();
        localObject18 = null;
        localObject19 = null;
        localObject20 = null;
        arrayOfByte4 = null;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 40L, 1L, true);
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject11 = localObject20;
        localObject16 = localObject2;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = com.tencent.mm.network.b.a((String)localObject17, null);
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        ((v)localObject1).setRequestMethod("GET");
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        ((v)localObject1).setRequestProperty("referer", (String)localObject3);
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        ((v)localObject1).setConnectTimeout(5000);
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        ((v)localObject1).setReadTimeout(5000);
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        if (com.tencent.mm.network.b.a((v)localObject1) == 0) {
          continue;
        }
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        i = ((v)localObject1).getResponseCode();
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        localObject3 = ((v)localObject1).getHeaderFields();
        if (localObject3 == null) {
          continue;
        }
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        localObject3 = (List)((Map)localObject3).get("X-ErrNo");
        if (localObject3 == null) {
          continue;
        }
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        if (((List)localObject3).size() <= 0) {
          continue;
        }
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        localObject3 = (String)((List)localObject3).get(0);
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        ab.e("MicroMsg.HttpGetAvatar", "checkHttpConnection failed! url:%s code:%d xErr:%s", new Object[] { localObject17, Integer.valueOf(i), localObject3 });
        switch (i)
        {
        case 404: 
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject18;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject19;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject20;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 6L, 1L, true);
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject18;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject19;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject20;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.qsU.e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.frE.getUsername(), ((v)localObject1).gek, Integer.valueOf(((v)localObject1).gdn), ((v)localObject1).url.getHost(), localObject17, localObject3 });
        }
      }
      catch (ProtocolException localProtocolException)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 1L, 1L, true);
        localObject8 = com.tencent.mm.plugin.report.service.h.qsU;
        localObject9 = localProtocolException.getMessage();
        localObject10 = this.frE.getUsername();
        if (localObject5 != null) {
          continue;
        }
        localObject1 = "null";
        if (localObject5 != null) {
          continue;
        }
        localObject2 = "null";
        if (localObject5 != null) {
          continue;
        }
        localObject3 = "null";
        ((com.tencent.mm.plugin.report.service.h)localObject8).e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(10001), localObject9, Integer.valueOf(0), localObject10, localObject1, localObject2, localObject3, localObject17, "" });
        ab.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", new Object[] { localObject17, localProtocolException.getClass().getSimpleName(), localProtocolException.getMessage() });
        localObject3 = localObject5;
        localObject2 = localObject13;
        localObject1 = arrayOfByte1;
        if (localObject3 == null) {
          continue;
        }
        try
        {
          ((v)localObject3).disconnect();
          if (localObject1 != null) {
            ((InputStream)localObject1).close();
          }
          if (localObject2 != null) {
            ((ByteArrayOutputStream)localObject2).close();
          }
        }
        catch (Exception localException1)
        {
          Object localObject7;
          byte[] arrayOfByte2;
          byte[] arrayOfByte3;
          Object localObject4;
          int j;
          Object localObject21;
          Object localObject23;
          Object localObject24;
          Object localObject25;
          Object localObject26;
          Object localObject22;
          Object localObject28;
          Object localObject29;
          Object localObject30;
          Object localObject31;
          Object localObject27;
          ab.e("MicroMsg.HttpGetAvatar", "exception:%s", new Object[] { bo.l(localException1) });
          ab.e("MicroMsg.HttpGetAvatar", "close conn failed : %s", new Object[] { localException1.getMessage() });
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 9L, 1L, true);
          continue;
        }
        AppMethodBeat.o(77856);
        return true;
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 3L, 1L, true);
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.qsU.e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.frE.getUsername(), ((v)localObject1).gek, Integer.valueOf(((v)localObject1).gdn), ((v)localObject1).url.getHost(), localObject17, localObject3 });
        continue;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 8L, 1L, true);
        localObject5 = com.tencent.mm.plugin.report.service.h.qsU;
        localObject9 = localSocketTimeoutException.getMessage();
        localObject10 = this.frE.getUsername();
        if (localObject8 != null) {
          continue;
        }
        localObject1 = "null";
        if (localObject8 != null) {
          continue;
        }
        localObject2 = "null";
        if (localObject8 != null) {
          continue;
        }
        localObject3 = "null";
        ((com.tencent.mm.plugin.report.service.h)localObject5).e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(10002), localObject9, Integer.valueOf(0), localObject10, localObject1, localObject2, localObject3, localObject17, "" });
        ab.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", new Object[] { localObject17, localSocketTimeoutException.getClass().getSimpleName(), localSocketTimeoutException.getMessage() });
        localObject1 = localObject7;
        localObject2 = localObject14;
        localObject3 = localObject8;
        continue;
        arrayOfByte2 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 4L, 1L, true);
        arrayOfByte2 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.qsU.e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.frE.getUsername(), ((v)localObject1).gek, Integer.valueOf(((v)localObject1).gdn), ((v)localObject1).url.getHost(), localObject17, localObject3 });
        continue;
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 7L, 1L, true);
        localObject5 = com.tencent.mm.plugin.report.service.h.qsU;
        localObject7 = localIOException.getMessage();
        localObject8 = this.frE.getUsername();
        if (localObject10 != null) {
          continue;
        }
        localObject1 = "null";
        if (localObject10 != null) {
          continue;
        }
        localObject2 = "null";
        if (localObject10 != null) {
          continue;
        }
        localObject3 = "null";
        ((com.tencent.mm.plugin.report.service.h)localObject5).e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(10003), localObject7, Integer.valueOf(0), localObject8, localObject1, localObject2, localObject3, localObject17, "" });
        ab.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", new Object[] { localObject17, localIOException.getClass().getSimpleName(), localIOException.getMessage() });
        localObject1 = localObject9;
        localObject2 = localObject15;
        localObject3 = localObject10;
        continue;
        arrayOfByte3 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 5L, 1L, true);
        arrayOfByte3 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.qsU.e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.frE.getUsername(), ((v)localObject1).gek, Integer.valueOf(((v)localObject1).gdn), ((v)localObject1).url.getHost(), localObject17, localObject3 });
        continue;
      }
      catch (Exception localException2)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 0L, 1L, true);
        localObject5 = com.tencent.mm.plugin.report.service.h.qsU;
        localObject7 = localException2.getMessage();
        localObject8 = this.frE.getUsername();
        if (localObject12 != null) {
          continue;
        }
        localObject1 = "null";
        if (localObject12 != null) {
          continue;
        }
        localObject2 = "null";
        if (localObject12 != null) {
          continue;
        }
        localObject3 = "null";
        ((com.tencent.mm.plugin.report.service.h)localObject5).e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(10003), localObject7, Integer.valueOf(0), localObject8, localObject1, localObject2, localObject3, localObject17, "" });
        ab.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", new Object[] { localObject17, localException2.getClass().getSimpleName(), localException2.getMessage() });
        localObject1 = localObject11;
        localObject2 = localObject16;
        localObject3 = localObject12;
        continue;
        localObject4 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        if (((v)localObject1).getHeaderFieldInt("X-Enc", 0) != 1) {
          continue;
        }
        bool1 = true;
        localObject4 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        this.bak = bool1;
        localObject4 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        i = ((v)localObject1).connection.getContentLength();
        localObject4 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject18;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject19;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject20;
        localObject16 = localObject2;
        localObject12 = localObject1;
        localObject3 = ((v)localObject1).getInputStream();
        if (localObject3 != null) {
          continue;
        }
        localObject4 = localObject3;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject2;
        localObject12 = localObject1;
        ab.d("MicroMsg.HttpGetAvatar", "getInputStream failed. url:%s", new Object[] { localObject17 });
        AppMethodBeat.o(77856);
        return true;
        bool1 = false;
        continue;
        localObject4 = localObject3;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject2;
        localObject12 = localObject1;
        arrayOfByte4 = new byte[1024];
        localObject4 = localObject3;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject2;
        localObject12 = localObject1;
        j = ((InputStream)localObject3).read(arrayOfByte4);
        if (j == -1) {
          continue;
        }
        localObject4 = localObject3;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject2;
        localObject12 = localObject1;
        ((ByteArrayOutputStream)localObject2).write(arrayOfByte4, 0, j);
        continue;
        localObject4 = localObject3;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 41L, 1L, true);
        localObject4 = localObject3;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject2;
        localObject12 = localObject1;
        if (!com.tencent.mm.sdk.a.b.dsf()) {
          continue;
        }
        localObject4 = localObject3;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.qsU.e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(20000), "", Integer.valueOf(i), this.frE.getUsername(), ((v)localObject1).gek, Integer.valueOf(((v)localObject1).gdn), ((v)localObject1).url.getHost(), localObject17, "" });
        localObject4 = localObject3;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject2;
        localObject12 = localObject1;
        this.frF = ((ByteArrayOutputStream)localObject2).toByteArray();
        localObject4 = localObject3;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject2;
        localObject12 = localObject1;
        ((ByteArrayOutputStream)localObject2).close();
        localObject18 = null;
        localObject19 = null;
        localObject20 = null;
        localObject21 = null;
        arrayOfByte4 = null;
        localObject4 = localObject3;
        localObject13 = arrayOfByte4;
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject14 = localObject19;
        localObject8 = localObject1;
        localObject9 = localObject3;
        localObject15 = localObject20;
        localObject10 = localObject1;
        localObject11 = localObject3;
        localObject16 = localObject21;
        localObject12 = localObject1;
        ((v)localObject1).disconnect();
        localObject23 = null;
        localObject24 = null;
        localObject25 = null;
        localObject26 = null;
        localObject22 = null;
        localObject4 = localObject3;
        localObject13 = arrayOfByte4;
        localObject5 = localObject22;
        localObject7 = localObject3;
        localObject14 = localObject19;
        localObject8 = localObject24;
        localObject9 = localObject3;
        localObject15 = localObject20;
        localObject10 = localObject25;
        localObject11 = localObject3;
        localObject16 = localObject21;
        localObject12 = localObject26;
        ((InputStream)localObject3).close();
        localObject28 = null;
        localObject29 = null;
        localObject30 = null;
        localObject31 = null;
        localObject27 = null;
        localObject1 = localObject28;
        localObject2 = localObject18;
        localObject3 = localObject23;
        if (i <= 0) {
          continue;
        }
        localObject4 = localObject27;
        localObject13 = arrayOfByte4;
        localObject5 = localObject22;
        localObject1 = localObject28;
        localObject2 = localObject18;
        localObject3 = localObject23;
        localObject7 = localObject29;
        localObject14 = localObject19;
        localObject8 = localObject24;
        localObject9 = localObject30;
        localObject15 = localObject20;
        localObject10 = localObject25;
        localObject11 = localObject31;
        localObject16 = localObject21;
        localObject12 = localObject26;
        if (this.frF.length >= i) {
          continue;
        }
        localObject4 = localObject27;
        localObject13 = arrayOfByte4;
        localObject5 = localObject22;
        localObject7 = localObject29;
        localObject14 = localObject19;
        localObject8 = localObject24;
        localObject9 = localObject30;
        localObject15 = localObject20;
        localObject10 = localObject25;
        localObject11 = localObject31;
        localObject16 = localObject21;
        localObject12 = localObject26;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 15L, 1L, true);
        localObject4 = localObject27;
        localObject13 = arrayOfByte4;
        localObject5 = localObject22;
        localObject7 = localObject29;
        localObject14 = localObject19;
        localObject8 = localObject24;
        localObject9 = localObject30;
        localObject15 = localObject20;
        localObject10 = localObject25;
        localObject11 = localObject31;
        localObject16 = localObject21;
        localObject12 = localObject26;
        ab.e("MicroMsg.HttpGetAvatar", "HTTP downloaded length is smaller than Content-Length field. Drop.");
        localObject1 = localObject28;
        localObject2 = localObject18;
        localObject3 = localObject23;
        continue;
        localObject1 = ((v)localObject5).gek;
        continue;
        localObject2 = Integer.valueOf(((v)localObject5).gdn);
        continue;
        localObject3 = ((v)localObject5).url.getHost();
        continue;
        localObject1 = ((v)localObject8).gek;
        continue;
        localObject2 = Integer.valueOf(((v)localObject8).gdn);
        continue;
        localObject3 = ((v)localObject8).url.getHost();
        continue;
        localObject1 = ((v)localObject10).gek;
        continue;
        localObject2 = Integer.valueOf(((v)localObject10).gdn);
        continue;
        localObject3 = ((v)localObject10).url.getHost();
        continue;
        localObject1 = localObject12.gek;
        continue;
        localObject2 = Integer.valueOf(localObject12.gdn);
        continue;
        localObject3 = localObject12.url.getHost();
        continue;
      }
      AppMethodBeat.o(77856);
      return true;
      localObject1 = (String)localObject17 + "?tp=wxpic";
      break;
      localObject3 = null;
      continue;
      localObject3 = "";
      continue;
      arrayOfByte1 = arrayOfByte4;
      localObject13 = localObject2;
      localObject5 = localObject1;
      localObject6 = localObject18;
      localObject14 = localObject2;
      localObject8 = localObject1;
      localObject9 = localObject19;
      localObject15 = localObject2;
      localObject10 = localObject1;
      localObject11 = localObject20;
      localObject16 = localObject2;
      localObject12 = localObject1;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 2L, 1L, true);
      arrayOfByte1 = arrayOfByte4;
      localObject13 = localObject2;
      localObject5 = localObject1;
      localObject6 = localObject18;
      localObject14 = localObject2;
      localObject8 = localObject1;
      localObject9 = localObject19;
      localObject15 = localObject2;
      localObject10 = localObject1;
      localObject11 = localObject20;
      localObject16 = localObject2;
      localObject12 = localObject1;
      com.tencent.mm.plugin.report.service.h.qsU.e(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.frE.getUsername(), ((v)localObject1).gek, Integer.valueOf(((v)localObject1).gdn), ((v)localObject1).url.getHost(), localObject17, localObject3 });
      continue;
      break label143;
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(77857);
    if ((this.frE == null) || (bo.isNullOrNil(this.frE.getUsername())))
    {
      AppMethodBeat.o(77857);
      return false;
    }
    if (bo.ce(this.frF))
    {
      this.fry.frq.remove(this.frE.getUsername());
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 10L, 1L, true);
      AppMethodBeat.o(77857);
      return false;
    }
    if (ao.a.flJ != null) {
      ao.a.flJ.cq(this.frF.length, 0);
    }
    this.fry.a(new c.a(this.fry, this.frE, this.frF, this.bak));
    AppMethodBeat.o(77857);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ah.c.b
 * JD-Core Version:    0.7.0.1
 */