package com.tencent.mm.plugin.finder.live;

import android.os.Message;
import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.model.cgi.aq;
import com.tencent.mm.plugin.finder.live.model.cgi.aq.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.bqw;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveNotifyRefreshManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNotifyRefresh;", "()V", "DEFAULT_INTERVAL", "", "EXT_INFO_TAG_END", "", "EXT_INFO_TAG_START", "REFRESH_NOTIFY", "TAG", "currentExposureMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/MsgInfo;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isPageFocus", "", "nextTaskTimeStampMap", "", "kotlin.jvm.PlatformType", "", "", "getNextTaskTimeStampMap", "()Ljava/util/Map;", "setNextTaskTimeStampMap", "(Ljava/util/Map;)V", "addRefreshTask", "", "data", "doOnPagePause", "doOnPageResume", "reqRefreshTips", "resetTimeStamp", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e BvY;
  private static final String BvZ;
  private static final String Bwa;
  private static Map<String, Long> Bwb;
  private static final int Bwc;
  private static volatile LinkedList<cc> Bwd;
  private static volatile boolean Bwe;
  private static final int Bwf;
  private static final String TAG;
  private static MMHandler handler;
  
  static
  {
    AppMethodBeat.i(350803);
    BvY = new e();
    TAG = "FinderLiveNotifyRefreshManager";
    BvZ = "<extinfo>";
    Bwa = "</extinfo>";
    Bwb = Collections.synchronizedMap((Map)new HashMap());
    Bwc = 1;
    Bwf = 60;
    handler = new MMHandler(TAG, e..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(350803);
  }
  
  private static void an(LinkedList<cc> paramLinkedList)
  {
    AppMethodBeat.i(350745);
    if (!Bwe)
    {
      AppMethodBeat.o(350745);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    final HashMap localHashMap = new HashMap();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      cc localcc = (cc)paramLinkedList.next();
      bqw localbqw = new bqw();
      String str = (String)XmlParser.parseXml(localcc.field_content, "msg", null).get(s.X(".msg.appmsg", ".extinfo.notifymsg.tipsinfo.tips_id"));
      Object localObject = (Long)Bwb.get(str);
      long l;
      label124:
      int i;
      if (localObject == null)
      {
        l = 0L;
        if (cn.getSyncServerTimeSecond() <= l) {
          break label290;
        }
        localObject = localcc.field_content;
        if (localObject != null) {
          break label252;
        }
        i = 0;
        label147:
        localObject = localcc.field_content;
        if (localObject != null) {
          break label271;
        }
      }
      label271:
      for (int j = 0;; j = kotlin.n.n.a((CharSequence)localObject, Bwa, 0, false, 6))
      {
        localObject = localcc.field_content;
        s.s(localObject, "it.content");
        localObject = ((String)localObject).substring(i, j + Bwa.length());
        s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if ((str == null) || (localObject == null)) {
          break;
        }
        localbqw.ZYN = str;
        localbqw.xml = ((String)localObject);
        localLinkedList.add(localbqw);
        localHashMap.put(str, localcc);
        break;
        l = ((Long)localObject).longValue();
        break label124;
        label252:
        i = kotlin.n.n.a((CharSequence)localObject, BvZ, 0, false, 6);
        break label147;
      }
      label290:
      Log.i(TAG, str + " is not allow to refresh, next time stamp:" + l);
    }
    paramLinkedList = new aq(localLinkedList, (aq.a)new a(localLinkedList, localHashMap));
    paramLinkedList.HcI = false;
    paramLinkedList.bFJ();
    AppMethodBeat.o(350745);
  }
  
  public static Map<String, Long> egL()
  {
    return Bwb;
  }
  
  public static void egM()
  {
    Bwe = true;
  }
  
  public static void egN()
  {
    AppMethodBeat.i(350755);
    Bwe = false;
    handler.removeMessages(Bwc);
    AppMethodBeat.o(350755);
  }
  
  public static void egO()
  {
    AppMethodBeat.i(350762);
    Bwb.clear();
    AppMethodBeat.o(350762);
  }
  
  private static final boolean p(Message paramMessage)
  {
    AppMethodBeat.i(350768);
    s.u(paramMessage, "it");
    if (paramMessage.what == Bwc)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramMessage = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.storage.MsgInfo>");
        AppMethodBeat.o(350768);
        throw paramMessage;
      }
      an((LinkedList)paramMessage);
    }
    AppMethodBeat.o(350768);
    return true;
  }
  
  /* Error */
  public final void ao(LinkedList<cc> paramLinkedList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 328
    //   5: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 329
    //   12: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 332	java/util/LinkedList:isEmpty	()Z
    //   19: ifne +9 -> 28
    //   22: getstatic 132	com/tencent/mm/plugin/finder/live/e:Bwe	Z
    //   25: ifne +12 -> 37
    //   28: ldc_w 328
    //   31: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_1
    //   38: putstatic 297	com/tencent/mm/plugin/finder/live/e:Bwd	Ljava/util/LinkedList;
    //   41: getstatic 86	com/tencent/mm/plugin/finder/live/e:TAG	Ljava/lang/String;
    //   44: ldc_w 334
    //   47: aload_1
    //   48: invokevirtual 337	java/util/LinkedList:size	()I
    //   51: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: invokestatic 179	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: getstatic 124	com/tencent/mm/plugin/finder/live/e:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   63: getstatic 109	com/tencent/mm/plugin/finder/live/e:Bwc	I
    //   66: invokevirtual 286	com/tencent/mm/sdk/platformtools/MMHandler:removeMessages	(I)V
    //   69: getstatic 124	com/tencent/mm/plugin/finder/live/e:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   72: astore_2
    //   73: aload_2
    //   74: aload_2
    //   75: getstatic 109	com/tencent/mm/plugin/finder/live/e:Bwc	I
    //   78: aload_1
    //   79: invokevirtual 347	com/tencent/mm/sdk/platformtools/MMHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   82: invokevirtual 350	com/tencent/mm/sdk/platformtools/MMHandler:sendMessage	(Landroid/os/Message;)Z
    //   85: pop
    //   86: ldc_w 328
    //   89: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: goto -58 -> 34
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	e
    //   0	100	1	paramLinkedList	LinkedList<cc>
    //   72	3	2	localMMHandler	MMHandler
    // Exception table:
    //   from	to	target	type
    //   2	28	95	finally
    //   28	34	95	finally
    //   37	92	95	finally
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/FinderLiveNotifyRefreshManager$reqRefreshTips$2", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshTipsResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements aq.a
  {
    a(LinkedList<bqw> paramLinkedList, HashMap<String, cc> paramHashMap) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bud parambud)
    {
      AppMethodBeat.i(351510);
      s.u(parambud, "resp");
      Log.i(e.aUw(), "[onCgiBack] errType=" + paramInt1 + " errCode=" + paramInt2 + " errMsg=" + paramString + " thread=" + Thread.currentThread() + " isPageFocus=" + e.egP());
      Log.i(e.aUw(), s.X("round_robin_interval = ", Long.valueOf(parambud.aabV)));
      Object localObject1;
      if ((e.egP()) && (paramInt2 == 0))
      {
        int i = k.qu(parambud.aabV, e.egQ());
        int j = cn.getSyncServerTimeSecond();
        paramString = parambud.aabU;
        if (paramString != null)
        {
          paramString = (Iterable)paramString;
          localObject1 = localHashMap;
          Iterator localIterator = paramString.iterator();
          while (localIterator.hasNext())
          {
            paramString = (bqw)localIterator.next();
            parambud = paramString.ZYN;
            if (parambud != null)
            {
              localObject2 = e.BvY;
              localObject2 = e.egL();
              s.s(localObject2, "nextTaskTimeStampMap");
              ((Map)localObject2).put(parambud, Long.valueOf(j + i));
            }
            Object localObject2 = (cc)((Map)localObject1).get(paramString.ZYN);
            if (localObject2 != null)
            {
              parambud = ((fi)localObject2).field_content;
              if (parambud == null)
              {
                paramInt1 = 0;
                parambud = ((fi)localObject2).field_content;
                if (parambud != null) {
                  break label309;
                }
              }
              label309:
              for (paramInt2 = 0;; paramInt2 = kotlin.n.n.a((CharSequence)parambud, e.egT(), 0, false, 6))
              {
                if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2)) {
                  break label328;
                }
                AppMethodBeat.o(351510);
                return;
                paramInt1 = kotlin.n.n.a((CharSequence)parambud, e.egS(), 0, false, 6);
                break;
              }
              label328:
              parambud = ((fi)localObject2).field_content;
              if (parambud == null) {
                paramString = "";
              }
              for (;;)
              {
                ((cc)localObject2).setContent(paramString);
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(((fi)localObject2).field_msgId, (cc)localObject2);
                paramInt1 = Util.safeParseInt(Util.nullAsNil((String)XmlParser.parseXml(((fi)localObject2).field_content, "msg", null).get(".msg.appmsg.extinfo.notifymsg.live_widget.status")));
                ((b)com.tencent.mm.kernel.h.az(b.class)).getFinderLiveNotifyExposureInfoStorage().V(((fi)localObject2).field_msgId, paramInt1);
                break;
                int k = e.egT().length();
                paramString = (CharSequence)String.valueOf(paramString.xml);
                parambud = kotlin.n.n.a((CharSequence)parambud, paramInt1, k + paramInt2, paramString).toString();
                paramString = parambud;
                if (parambud == null) {
                  paramString = "";
                }
              }
            }
          }
        }
        paramString = e.egR();
        if (paramString != null)
        {
          e.egU().removeMessages(e.egV());
          e.egU().sendMessageDelayed(e.egU().obtainMessage(e.egV(), paramString), i * 1000L);
          AppMethodBeat.o(351510);
        }
      }
      else
      {
        paramString = ((Iterable)this.Bwg).iterator();
        while (paramString.hasNext())
        {
          parambud = (bqw)paramString.next();
          Log.i(e.aUw(), s.X(parambud.ZYN, " fail ,set interval 60s"));
          localObject1 = e.BvY;
          localObject1 = e.egL();
          s.s(localObject1, "nextTaskTimeStampMap");
          ((Map)localObject1).put(parambud.ZYN, Long.valueOf(cn.getSyncServerTimeSecond() + e.egQ()));
        }
      }
      AppMethodBeat.o(351510);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.e
 * JD-Core Version:    0.7.0.1
 */