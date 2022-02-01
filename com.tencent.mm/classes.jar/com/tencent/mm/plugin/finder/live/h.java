package com.tencent.mm.plugin.finder.live;

import android.os.Message;
import com.tencent.c.a.a.a.b;
import com.tencent.c.a.a.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.live.model.cgi.ah.a;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveNotifyRefreshManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNotifyRefresh;", "()V", "DEFAULT_INTERVAL", "", "EXT_INFO_TAG_END", "", "EXT_INFO_TAG_START", "REFRESH_NOTIFY", "TAG", "currentExposureMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/MsgInfo;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isPageFocus", "", "nextTaskTimeStampMap", "", "kotlin.jvm.PlatformType", "", "", "getNextTaskTimeStampMap", "()Ljava/util/Map;", "setNextTaskTimeStampMap", "(Ljava/util/Map;)V", "addRefreshTask", "", "data", "doOnPagePause", "doOnPageResume", "reqRefreshTips", "resetTimeStamp", "plugin-finder_release"})
public final class h
{
  private static final String TAG = "FinderLiveNotifyRefreshManager";
  private static MMHandler handler;
  private static final String xVm = "<extinfo>";
  private static final String xVn = "</extinfo>";
  private static Map<String, Long> xVo;
  private static final int xVp = 1;
  private static volatile LinkedList<ca> xVq;
  private static volatile boolean xVr = false;
  private static final int xVs = 60;
  public static final h xVt;
  
  static
  {
    AppMethodBeat.i(271292);
    xVt = new h();
    TAG = "FinderLiveNotifyRefreshManager";
    xVm = "<extinfo>";
    xVn = "</extinfo>";
    xVo = Collections.synchronizedMap((Map)new HashMap());
    xVp = 1;
    xVs = 60;
    handler = new MMHandler(TAG, (MMHandler.Callback)a.xVu);
    AppMethodBeat.o(271292);
  }
  
  public static Map<String, Long> dwo()
  {
    return xVo;
  }
  
  public static void dwp()
  {
    xVr = true;
  }
  
  public static void dwq()
  {
    AppMethodBeat.i(271289);
    xVr = false;
    handler.removeMessages(xVp);
    AppMethodBeat.o(271289);
  }
  
  public static void dwr()
  {
    AppMethodBeat.i(271291);
    xVo.clear();
    AppMethodBeat.o(271291);
  }
  
  /* Error */
  public final void ai(LinkedList<ca> paramLinkedList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 296
    //   5: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 297
    //   12: invokestatic 300	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 303	java/util/LinkedList:isEmpty	()Z
    //   19: ifne +9 -> 28
    //   22: getstatic 125	com/tencent/mm/plugin/finder/live/h:xVr	Z
    //   25: ifne +12 -> 37
    //   28: ldc_w 296
    //   31: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_1
    //   38: putstatic 291	com/tencent/mm/plugin/finder/live/h:xVq	Ljava/util/LinkedList;
    //   41: getstatic 81	com/tencent/mm/plugin/finder/live/h:TAG	Ljava/lang/String;
    //   44: new 163	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 305
    //   51: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_1
    //   55: invokevirtual 309	java/util/LinkedList:size	()I
    //   58: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: getstatic 115	com/tencent/mm/plugin/finder/live/h:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   70: getstatic 100	com/tencent/mm/plugin/finder/live/h:xVp	I
    //   73: invokevirtual 277	com/tencent/mm/sdk/platformtools/MMHandler:removeMessages	(I)V
    //   76: getstatic 115	com/tencent/mm/plugin/finder/live/h:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   79: astore_2
    //   80: aload_2
    //   81: aload_2
    //   82: getstatic 100	com/tencent/mm/plugin/finder/live/h:xVp	I
    //   85: aload_1
    //   86: invokevirtual 316	com/tencent/mm/sdk/platformtools/MMHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   89: invokevirtual 320	com/tencent/mm/sdk/platformtools/MMHandler:sendMessage	(Landroid/os/Message;)Z
    //   92: pop
    //   93: ldc_w 296
    //   96: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: goto -65 -> 34
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	h
    //   0	107	1	paramLinkedList	LinkedList<ca>
    //   79	3	2	localMMHandler	MMHandler
    // Exception table:
    //   from	to	target	type
    //   2	28	102	finally
    //   28	34	102	finally
    //   37	99	102	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements MMHandler.Callback
  {
    public static final a xVu;
    
    static
    {
      AppMethodBeat.i(276468);
      xVu = new a();
      AppMethodBeat.o(276468);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(276467);
      int i = paramMessage.what;
      h localh = h.xVt;
      if (i == h.dwz())
      {
        localh = h.xVt;
        paramMessage = paramMessage.obj;
        if (paramMessage == null)
        {
          paramMessage = new t("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.storage.MsgInfo>");
          AppMethodBeat.o(276467);
          throw paramMessage;
        }
        h.aj((LinkedList)paramMessage);
      }
      AppMethodBeat.o(276467);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLiveNotifyRefreshManager$reqRefreshTips$2", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshTipsResponse;", "plugin-finder_release"})
  public static final class b
    implements ah.a
  {
    b(HashMap paramHashMap, LinkedList paramLinkedList) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bib parambib)
    {
      AppMethodBeat.i(284587);
      p.k(parambib, "resp");
      Object localObject1 = h.xVt;
      localObject1 = h.dws();
      paramString = new StringBuilder("[onCgiBack] errType=").append(paramInt1).append(" errCode=").append(paramInt2).append(" errMsg=").append(paramString).append(" thread=").append(Thread.currentThread()).append(" isPageFocus=");
      Object localObject2 = h.xVt;
      Log.i((String)localObject1, h.dwt());
      paramString = h.xVt;
      Log.i(h.dws(), "round_robin_interval = " + parambib.SSD);
      paramString = h.xVt;
      int i;
      if ((h.dwt()) && (paramInt2 == 0))
      {
        paramInt1 = parambib.SSD;
        paramString = h.xVt;
        i = kotlin.k.i.ov(paramInt1, h.dwu());
        int j = cm.bfF();
        paramString = parambib.SSC;
        if (paramString != null)
        {
          parambib = ((Iterable)paramString).iterator();
          while (parambib.hasNext())
          {
            paramString = (bfp)parambib.next();
            localObject1 = paramString.SQm;
            if (localObject1 != null)
            {
              localObject2 = h.xVt;
              localObject2 = h.dwo();
              p.j(localObject2, "nextTaskTimeStampMap");
              ((Map)localObject2).put(localObject1, Long.valueOf(j + i));
            }
            localObject1 = (ca)((Map)this.pVI).get(paramString.SQm);
            if (localObject1 != null)
            {
              localObject2 = ((ca)localObject1).getContent();
              h localh;
              if (localObject2 != null)
              {
                localObject2 = (CharSequence)localObject2;
                localh = h.xVt;
                paramInt1 = kotlin.n.n.a((CharSequence)localObject2, h.dwv(), 0, false, 6);
                localObject2 = ((ca)localObject1).getContent();
                if (localObject2 == null) {
                  break label372;
                }
                localObject2 = (CharSequence)localObject2;
                localh = h.xVt;
              }
              label372:
              for (paramInt2 = kotlin.n.n.a((CharSequence)localObject2, h.dww(), 0, false, 6);; paramInt2 = 0)
              {
                if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2)) {
                  break label377;
                }
                AppMethodBeat.o(284587);
                return;
                paramInt1 = 0;
                break;
              }
              label377:
              localObject2 = ((ca)localObject1).getContent();
              if (localObject2 != null)
              {
                localh = h.xVt;
                int k = h.dww().length();
                paramString = (CharSequence)String.valueOf(paramString.xml);
                if (localObject2 == null)
                {
                  paramString = new t("null cannot be cast to non-null type kotlin.CharSequence");
                  AppMethodBeat.o(284587);
                  throw paramString;
                }
                paramString = kotlin.n.n.a((CharSequence)localObject2, paramInt1, k + paramInt2, paramString).toString();
                if (paramString != null) {
                  break label780;
                }
              }
              paramString = "";
            }
          }
        }
      }
      label780:
      for (;;)
      {
        ((ca)localObject1).setContent(paramString);
        paramString = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
        p.j(paramString, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.n)paramString).eSe().a(((ca)localObject1).apG(), (ca)localObject1);
        paramInt1 = Util.safeParseInt(Util.nullAsNil((String)XmlParser.parseXml(((ca)localObject1).getContent(), "msg", null).get(".msg.appmsg.extinfo.notifymsg.live_widget.status")));
        ((b)com.tencent.mm.kernel.h.ag(b.class)).getFinderLiveNotifyExposureInfoStorage().K(((ca)localObject1).apG(), paramInt1);
        break;
        paramString = h.xVt;
        paramString = h.dwx();
        if (paramString != null)
        {
          parambib = h.xVt;
          parambib = h.dwy();
          localObject1 = h.xVt;
          parambib.removeMessages(h.dwz());
          parambib = h.xVt;
          parambib = h.dwy();
          localObject1 = h.xVt;
          localObject1 = h.dwy();
          localObject2 = h.xVt;
          parambib.sendMessageDelayed(((MMHandler)localObject1).obtainMessage(h.dwz(), paramString), i * 1000L);
          AppMethodBeat.o(284587);
          return;
        }
        AppMethodBeat.o(284587);
        return;
        paramString = ((Iterable)this.xVv).iterator();
        while (paramString.hasNext())
        {
          parambib = (bfp)paramString.next();
          localObject1 = h.xVt;
          Log.i(h.dws(), parambib.SQm + " fail ,set interval 60s");
          localObject1 = h.xVt;
          localObject1 = h.dwo();
          p.j(localObject1, "nextTaskTimeStampMap");
          parambib = parambib.SQm;
          long l = cm.bfF();
          localObject2 = h.xVt;
          ((Map)localObject1).put(parambib, Long.valueOf(l + h.dwu()));
        }
        AppMethodBeat.o(284587);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.h
 * JD-Core Version:    0.7.0.1
 */