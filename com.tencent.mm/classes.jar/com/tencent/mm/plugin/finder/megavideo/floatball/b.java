package com.tencent.mm.plugin.finder.megavideo.floatball;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI.a;
import com.tencent.mm.plugin.finder.report.ax;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "context", "Landroid/content/Context;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "getContext", "()Landroid/content/Context;", "initReportInfo", "", "isSupportSwipeToFloatBall", "", "onCreate", "floatBallType", "", "floatBallKey", "", "onMenuFloatBallSelected", "enterFloatBall", "generateType", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.ball.service.e
{
  public static final a EzA;
  private static final com.tencent.mm.plugin.ball.c.e roL;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(341770);
    EzA = new a((byte)0);
    roL = (com.tencent.mm.plugin.ball.c.e)new b();
    AppMethodBeat.o(341770);
  }
  
  public b(Context paramContext, com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
    AppMethodBeat.i(341756);
    this.context = paramContext;
    AppMethodBeat.o(341756);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(341798);
    super.B(paramBoolean, paramInt);
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.vjV.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
      localObject1 = new dnq();
    }
    try
    {
      ((dnq)localObject1).parseFrom((byte[])localObject2);
      localObject2 = as.GSQ;
      localObject2 = as.a.hu(this.context);
      if (localObject2 == null)
      {
        localObject6 = null;
        localObject2 = ((dnq)localObject1).aaUQ;
        s.s(localObject2, "floatBallInfo.cacheNewVideoList");
        localObject1 = (FinderObject)p.ae((List)localObject2, ((dnq)localObject1).aaUN);
        if (localObject1 != null) {
          break label280;
        }
        localObject1 = null;
        int i = cYn() + 1;
        long l2 = com.tencent.mm.model.cn.bDw();
        String str1 = s.X("uin_", Long.valueOf(l2));
        this.vjV.dv("KEY_FLOAT_BALL_TASK_ORDER", i);
        this.vjV.fx("KEY_FLOAT_BALL_MINI_SESSION_ID", str1);
        this.vjV.ac("KEY_FLOAT_BALL_VERSION", 1L);
        localObject2 = ax.Fur;
        if (paramInt != 2) {
          break label426;
        }
        paramInt = 2;
        if (localObject1 != null) {
          break label431;
        }
        l1 = 0L;
        String str2 = d.hF(l1);
        if (localObject6 != null) {
          break label441;
        }
        localObject2 = "";
        if (localObject6 != null) {
          break label464;
        }
        localObject5 = "";
        if (localObject6 != null) {
          break label487;
        }
        localObject6 = "";
        if (localObject1 != null) {
          break label510;
        }
        l1 = 0L;
        ax.a(l2, paramInt, i, str2, str1, (String)localObject2, (String)localObject5, (String)localObject6, d.hF(l1));
        AppMethodBeat.o(341798);
      }
    }
    finally
    {
      for (;;)
      {
        long l1;
        Object localObject5;
        Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", new Object[] { localObject3 });
        continue;
        Object localObject6 = localObject3.fou();
        continue;
        label280:
        localObject1 = ((FinderObject)localObject1).attachmentList;
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((atr)localObject1).ZEi;
          if (localObject1 == null)
          {
            localObject1 = null;
          }
          else
          {
            Object localObject4 = ((Iterable)localObject1).iterator();
            Object localObject7;
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject1 = ((Iterator)localObject4).next();
              localObject5 = (atq)localObject1;
              localObject7 = av.GiL;
              s.s(localObject5, "it");
            } while (!av.a((atq)localObject5));
            for (;;)
            {
              localObject1 = (atq)localObject1;
              if (localObject1 != null) {
                break label398;
              }
              localObject1 = null;
              break;
              localObject1 = null;
            }
            label398:
            localObject1 = ((atq)localObject1).ZEf;
            if (localObject1 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = ((byx)localObject1).ZXx;
              continue;
              label426:
              paramInt = 1;
              continue;
              label431:
              l1 = ((dne)localObject1).id;
              continue;
              label441:
              localObject5 = ((bui)localObject6).sessionId;
              localObject4 = localObject5;
              if (localObject5 == null)
              {
                localObject4 = "";
                continue;
                label464:
                localObject7 = ((bui)localObject6).zIO;
                localObject5 = localObject7;
                if (localObject7 == null)
                {
                  localObject5 = "";
                  continue;
                  label487:
                  localObject7 = ((bui)localObject6).zIB;
                  localObject6 = localObject7;
                  if (localObject7 == null)
                  {
                    localObject6 = "";
                    continue;
                    label510:
                    localObject1 = ((dne)localObject1).aaUv;
                    if (localObject1 == null) {
                      l1 = 0L;
                    } else {
                      l1 = ((dno)localObject1).hKN;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(341773);
    super.J(paramInt, paramString);
    cYv().mUU = 17;
    AppMethodBeat.o(341773);
  }
  
  public final boolean bhU()
  {
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper$Companion;", "", "()V", "INNER_VERSION", "", "INTERVAL_REMOVE_THEN_ADD", "KEY_FLOAT_BALL_INFO", "", "KEY_FLOAT_BALL_MINI_SESSION_ID", "KEY_FLOAT_BALL_TASK_ORDER", "KEY_FLOAT_BALL_VERSION", "KEY_VIDEO_FLOAT_BALL_INFO", "TAG", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "handleBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "isFromVideoBall", "", "i", "Landroid/content/Intent;", "startListeningFloatBallInfoClicked", "stopListeningFloatBallInfoClicked", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      extends u
      implements a<ah>
    {
      public a(com.tencent.mm.plugin.ball.c.b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper$Companion$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.ball.c.f
  {
    /* Error */
    public final void b(BallInfo paramBallInfo)
    {
      // Byte code:
      //   0: ldc 35
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: ifnull +312 -> 318
      //   9: getstatic 45	com/tencent/mm/plugin/finder/megavideo/floatball/b:EzA	Lcom/tencent/mm/plugin/finder/megavideo/floatball/b$a;
      //   12: astore_2
      //   13: aload_1
      //   14: ldc 46
      //   16: invokestatic 52	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
      //   19: aload_1
      //   20: ldc 54
      //   22: invokevirtual 60	com/tencent/mm/plugin/ball/model/BallInfo:getByteArrayExtra	(Ljava/lang/String;)[B
      //   25: astore_3
      //   26: new 62	com/tencent/mm/protocal/protobuf/dnq
      //   29: dup
      //   30: invokespecial 63	com/tencent/mm/protocal/protobuf/dnq:<init>	()V
      //   33: astore_2
      //   34: aload_2
      //   35: aload_3
      //   36: invokevirtual 67	com/tencent/mm/protocal/protobuf/dnq:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   39: pop
      //   40: new 69	android/content/Intent
      //   43: dup
      //   44: invokespecial 70	android/content/Intent:<init>	()V
      //   47: astore_3
      //   48: aload_2
      //   49: getfield 74	com/tencent/mm/protocal/protobuf/dnq:aaUQ	Ljava/util/LinkedList;
      //   52: astore 4
      //   54: aload 4
      //   56: ldc 76
      //   58: invokestatic 79	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   61: aload 4
      //   63: checkcast 81	java/lang/Iterable
      //   66: astore 5
      //   68: new 83	java/util/ArrayList
      //   71: dup
      //   72: aload 5
      //   74: bipush 10
      //   76: invokestatic 89	kotlin/a/p:a	(Ljava/lang/Iterable;I)I
      //   79: invokespecial 91	java/util/ArrayList:<init>	(I)V
      //   82: checkcast 93	java/util/Collection
      //   85: astore 4
      //   87: aload 5
      //   89: invokeinterface 97 1 0
      //   94: astore 5
      //   96: aload 5
      //   98: invokeinterface 103 1 0
      //   103: ifeq +75 -> 178
      //   106: aload 5
      //   108: invokeinterface 107 1 0
      //   113: checkcast 109	com/tencent/mm/protocal/protobuf/FinderObject
      //   116: astore 6
      //   118: getstatic 115	com/tencent/mm/plugin/finder/storage/FinderItem:Companion	Lcom/tencent/mm/plugin/finder/storage/FinderItem$a;
      //   121: astore 7
      //   123: aload 6
      //   125: ldc 117
      //   127: invokestatic 79	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   130: aload 6
      //   132: iconst_1
      //   133: invokestatic 123	com/tencent/mm/plugin/finder/storage/FinderItem$a:e	(Lcom/tencent/mm/protocal/protobuf/FinderObject;I)Lcom/tencent/mm/plugin/finder/storage/FinderItem;
      //   136: astore 6
      //   138: getstatic 129	com/tencent/mm/plugin/finder/storage/logic/d:FND	Lcom/tencent/mm/plugin/finder/storage/logic/d$a;
      //   141: astore 7
      //   143: aload 4
      //   145: aload 6
      //   147: invokestatic 134	com/tencent/mm/plugin/finder/storage/logic/d$a:a	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;
      //   150: invokeinterface 138 2 0
      //   155: pop
      //   156: goto -60 -> 96
      //   159: astore_3
      //   160: ldc 140
      //   162: ldc 142
      //   164: iconst_1
      //   165: anewarray 144	java/lang/Object
      //   168: dup
      //   169: iconst_0
      //   170: aload_3
      //   171: aastore
      //   172: invokestatic 149	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   175: goto -135 -> 40
      //   178: aload 4
      //   180: checkcast 151	java/util/List
      //   183: astore 4
      //   185: getstatic 157	com/tencent/mm/plugin/finder/utils/av:GiL	Lcom/tencent/mm/plugin/finder/utils/av;
      //   188: astore 5
      //   190: aload_2
      //   191: getfield 161	com/tencent/mm/protocal/protobuf/dnq:aaUN	I
      //   194: aload 4
      //   196: aload_2
      //   197: getfield 165	com/tencent/mm/protocal/protobuf/dnq:lastBuffer	Lcom/tencent/mm/bx/b;
      //   200: aload_3
      //   201: invokestatic 168	com/tencent/mm/plugin/finder/utils/av:a	(ILjava/util/List;Lcom/tencent/mm/bx/b;Landroid/content/Intent;)V
      //   204: aload_3
      //   205: ldc 170
      //   207: aload_2
      //   208: getfield 173	com/tencent/mm/protocal/protobuf/dnq:aaUP	I
      //   211: invokevirtual 177	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   214: pop
      //   215: aload_3
      //   216: ldc 54
      //   218: aload_2
      //   219: invokevirtual 181	com/tencent/mm/protocal/protobuf/dnq:toByteArray	()[B
      //   222: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
      //   225: pop
      //   226: aload_3
      //   227: ldc 186
      //   229: aload_1
      //   230: ldc 186
      //   232: iconst_0
      //   233: invokevirtual 190	com/tencent/mm/plugin/ball/model/BallInfo:getIntExtra	(Ljava/lang/String;I)I
      //   236: invokevirtual 177	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   239: pop
      //   240: aload_3
      //   241: ldc 192
      //   243: aload_1
      //   244: ldc 192
      //   246: ldc 193
      //   248: invokevirtual 197	com/tencent/mm/plugin/ball/model/BallInfo:fy	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   251: invokevirtual 200	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   254: pop
      //   255: aload_3
      //   256: ldc 202
      //   258: aload_2
      //   259: getfield 205	com/tencent/mm/protocal/protobuf/dnq:aaUO	I
      //   262: i2l
      //   263: ldc2_w 206
      //   266: lmul
      //   267: invokevirtual 210	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
      //   270: pop
      //   271: aload_3
      //   272: ldc 211
      //   274: invokevirtual 215	android/content/Intent:addFlags	(I)Landroid/content/Intent;
      //   277: pop
      //   278: ldc 217
      //   280: invokestatic 223	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   283: checkcast 217	com/tencent/mm/plugin/findersdk/a/cn
      //   286: bipush 8
      //   288: bipush 6
      //   290: bipush 45
      //   292: aload_3
      //   293: invokeinterface 227 5 0
      //   298: pop
      //   299: getstatic 233	com/tencent/mm/plugin/finder/utils/a:GfO	Lcom/tencent/mm/plugin/finder/utils/a;
      //   302: astore_1
      //   303: invokestatic 239	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   306: astore_1
      //   307: aload_1
      //   308: ldc 241
      //   310: invokestatic 79	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   313: aload_1
      //   314: aload_3
      //   315: invokestatic 245	com/tencent/mm/plugin/finder/utils/a:au	(Landroid/content/Context;Landroid/content/Intent;)V
      //   318: ldc 35
      //   320: invokestatic 248	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   323: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	324	0	this	b
      //   0	324	1	paramBallInfo	BallInfo
      //   12	247	2	localObject1	Object
      //   25	23	3	localObject2	Object
      //   159	156	3	localIntent	android.content.Intent
      //   52	143	4	localObject3	Object
      //   66	123	5	localObject4	Object
      //   116	30	6	localObject5	Object
      //   121	21	7	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   34	40	159	finally
    }
    
    public final void c(BallInfo paramBallInfo)
    {
      Object localObject2 = null;
      AppMethodBeat.i(341794);
      Object localObject3;
      Object localObject1;
      if (paramBallInfo != null)
      {
        localObject3 = paramBallInfo.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
        localObject1 = new dnq();
      }
      Object localObject5;
      try
      {
        ((dnq)localObject1).parseFrom((byte[])localObject3);
        localObject3 = FinderLongVideoTimelineUI.Bqh;
        int i = FinderLongVideoTimelineUI.a.Op(((dnq)localObject1).aaUP);
        localObject3 = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(8, 6, i, null);
        String str = paramBallInfo.fy("KEY_FLOAT_BALL_MINI_SESSION_ID", "");
        localObject5 = ((dnq)localObject1).aaUQ;
        s.s(localObject5, "floatBallInfo.cacheNewVideoList");
        localObject1 = (FinderObject)p.ae((List)localObject5, ((dnq)localObject1).aaUN);
        if (localObject1 == null)
        {
          localObject1 = localObject2;
          if (localObject1 != null)
          {
            i = paramBallInfo.getIntExtra("KEY_FLOAT_BALL_TASK_ORDER", 0);
            paramBallInfo = ax.Fur;
            s.s(str, "miniSessionId");
            paramBallInfo = d.hF(((dne)localObject1).id);
            s.s(localObject3, "contextId");
            ax.a(str, i, paramBallInfo, "", (String)localObject3, "");
          }
          AppMethodBeat.o(341794);
          return;
        }
      }
      finally
      {
        do
        {
          do
          {
            for (;;)
            {
              Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", new Object[] { localObject4 });
            }
            localObject5 = ((FinderObject)localObject1).attachmentList;
            localObject1 = localObject2;
          } while (localObject5 == null);
          localObject5 = ((atr)localObject5).ZEi;
          localObject1 = localObject2;
        } while (localObject5 == null);
        localObject5 = ((Iterable)localObject5).iterator();
      }
      atq localatq;
      do
      {
        if (!((Iterator)localObject5).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject5).next();
        localatq = (atq)localObject1;
        av localav = av.GiL;
        s.s(localatq, "it");
      } while (!av.a(localatq));
      for (;;)
      {
        localObject5 = (atq)localObject1;
        localObject1 = localObject2;
        if (localObject5 == null) {
          break;
        }
        localObject5 = ((atq)localObject5).ZEf;
        localObject1 = localObject2;
        if (localObject5 == null) {
          break;
        }
        localObject1 = ((byx)localObject5).ZXx;
        break;
        localObject1 = null;
      }
    }
    
    public final void d(BallInfo paramBallInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.floatball.b
 * JD-Core Version:    0.7.0.1
 */