package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.report.q.bw;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "getPlugin", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "setPlugin", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;)V", "pos", "", "getPos", "()I", "setPos", "(I)V", "released", "", "activatePlugin", "", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "isFromFloat", "forceUpdate", "deactivatePlugin", "release", "reportWhenSlideLiveRoom", "oldPos", "newPos", "sameItem", "newPlugin", "samePos", "setReportParams", "context", "Landroid/content/Context;", "updatePlugins", "updateRecord", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public FinderLiveVisitorPluginLayout Bxq;
  final String TAG;
  int pos;
  boolean released;
  private final bui reportObj;
  
  public i(bui parambui)
  {
    this.reportObj = parambui;
    this.TAG = "Finder.FinderLiveViewCallback.Manager";
    this.pos = -1;
  }
  
  private static final void a(i parami, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
  {
    Object localObject = null;
    AppMethodBeat.i(350753);
    s.u(parami, "this$0");
    k localk;
    Context localContext;
    label57:
    long l;
    if ((paramInt1 != -1) && (paramInt1 != paramInt2))
    {
      localk = k.Doi;
      parami = parami.Bxq;
      if (parami != null) {
        break label137;
      }
      localContext = null;
      JSONObject localJSONObject = new JSONObject();
      if (paramf != null) {
        break label146;
      }
      parami = "";
      localJSONObject.put("username", parami);
      if (paramf != null) {
        break label201;
      }
      l = 0L;
      label73:
      localJSONObject.put("liveId", b.hF(l));
      k.a(q.bu.DCr, localJSONObject.toString(), 0L, null, null, null, 60);
      paramf = q.bw.DDB;
      parami = aj.CGT;
      parami = aj.egD();
      if (parami != null) {
        break label260;
      }
    }
    label260:
    for (parami = localObject;; parami = parami.CFn)
    {
      localk.a(localContext, paramf, parami);
      AppMethodBeat.o(350753);
      return;
      label137:
      localContext = parami.getContext();
      break;
      label146:
      parami = paramf.BxG;
      if (parami == null)
      {
        parami = "";
        break label57;
      }
      parami = (e)parami.business(e.class);
      if (parami == null)
      {
        parami = "";
        break label57;
      }
      String str = parami.mIC;
      parami = str;
      if (str != null) {
        break label57;
      }
      parami = "";
      break label57;
      label201:
      parami = paramf.BxG;
      if (parami == null)
      {
        l = 0L;
        break label73;
      }
      parami = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parami.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (parami == null)
      {
        l = 0L;
        break label73;
      }
      parami = parami.liveInfo;
      if (parami == null)
      {
        l = 0L;
        break label73;
      }
      l = parami.liveId;
      break label73;
    }
  }
  
  /* Error */
  public final void a(FinderLiveVisitorPluginLayout paramFinderLiveVisitorPluginLayout, int paramInt, com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 196
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 197
    //   8: invokestatic 97	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 86	com/tencent/mm/plugin/finder/live/i:TAG	Ljava/lang/String;
    //   15: astore 8
    //   17: new 199	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 201
    //   23: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 88	com/tencent/mm/plugin/finder/live/i:pos	I
    //   30: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: bipush 45
    //   35: invokevirtual 211	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   38: astore 9
    //   40: aload_0
    //   41: getfield 105	com/tencent/mm/plugin/finder/live/i:Bxq	Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;
    //   44: astore 10
    //   46: aload 10
    //   48: ifnull +71 -> 119
    //   51: aload 10
    //   53: invokevirtual 214	java/lang/Object:hashCode	()I
    //   56: istore 6
    //   58: aload 8
    //   60: aload 9
    //   62: iload 6
    //   64: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc 216
    //   69: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload_2
    //   73: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: bipush 45
    //   78: invokevirtual 211	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 220	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:hashCode	()I
    //   85: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: ldc 222
    //   90: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: getfield 224	com/tencent/mm/plugin/finder/live/i:released	Z
    //   97: invokevirtual 227	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   100: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 224	com/tencent/mm/plugin/finder/live/i:released	Z
    //   110: ifeq +15 -> 125
    //   113: ldc 196
    //   115: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: iconst_0
    //   120: istore 6
    //   122: goto -64 -> 58
    //   125: getstatic 239	com/tencent/mm/plugin/finder/utils/bd:Gli	Lcom/tencent/mm/plugin/finder/utils/bd;
    //   128: astore 8
    //   130: invokestatic 242	com/tencent/mm/plugin/finder/utils/bd:fhS	()Ljava/lang/String;
    //   133: aload_1
    //   134: invokevirtual 246	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:getData	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/f;
    //   137: getfield 250	com/tencent/mm/plugin/finder/live/viewmodel/data/f:Ebr	Lcom/tencent/mm/live/api/LiveConfig;
    //   140: getfield 253	com/tencent/mm/live/api/LiveConfig:liveId	J
    //   143: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   146: invokestatic 263	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   149: astore 9
    //   151: getstatic 269	com/tencent/mm/plugin/finder/utils/bb:GjM	Lcom/tencent/mm/plugin/finder/utils/bb$a;
    //   154: astore 10
    //   156: invokestatic 273	com/tencent/mm/plugin/finder/utils/bb:fhe	()Lcom/tencent/mm/plugin/finder/utils/bb$c;
    //   159: getfield 278	com/tencent/mm/plugin/finder/utils/bb$c:name	Ljava/lang/String;
    //   162: astore 10
    //   164: iload 4
    //   166: ifne +671 -> 837
    //   169: iconst_1
    //   170: istore 7
    //   172: aload 8
    //   174: aload 9
    //   176: aload 10
    //   178: aconst_null
    //   179: iload 7
    //   181: iconst_0
    //   182: iconst_0
    //   183: bipush 52
    //   185: invokestatic 281	com/tencent/mm/plugin/finder/utils/bd:a	(Lcom/tencent/mm/plugin/finder/utils/bd;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/bx/b;ZZZI)V
    //   188: aload_1
    //   189: invokevirtual 160	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:getContext	()Landroid/content/Context;
    //   192: astore 10
    //   194: aload 10
    //   196: ldc_w 283
    //   199: invokestatic 286	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   202: iload 4
    //   204: ifne +228 -> 432
    //   207: getstatic 292	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   210: astore 8
    //   212: getstatic 296	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   215: getfield 301	com/tencent/mm/plugin/finder/live/report/q:DpA	Z
    //   218: ifne +214 -> 432
    //   221: getstatic 292	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   224: astore 8
    //   226: getstatic 296	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   229: astore 11
    //   231: aload_3
    //   232: ifnonnull +611 -> 843
    //   235: aconst_null
    //   236: astore 9
    //   238: aload 9
    //   240: astore 8
    //   242: aload 9
    //   244: ifnonnull +11 -> 255
    //   247: aload_3
    //   248: ifnonnull +622 -> 870
    //   251: ldc 109
    //   253: astore 8
    //   255: aload 8
    //   257: ldc_w 303
    //   260: invokestatic 97	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   263: aload 11
    //   265: aload 8
    //   267: putfield 306	com/tencent/mm/plugin/finder/live/report/q:Dqb	Ljava/lang/String;
    //   270: getstatic 312	com/tencent/mm/plugin/finder/live/report/q$n:Dtu	Lcom/tencent/mm/plugin/finder/live/report/q$n;
    //   273: getfield 315	com/tencent/mm/plugin/finder/live/report/q$n:scene	Ljava/lang/String;
    //   276: invokestatic 320	com/tencent/mm/plugin/expt/hellhound/a:aqz	(Ljava/lang/String;)V
    //   279: getstatic 292	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   282: astore 8
    //   284: getstatic 296	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   287: getstatic 312	com/tencent/mm/plugin/finder/live/report/q$n:Dtu	Lcom/tencent/mm/plugin/finder/live/report/q$n;
    //   290: getfield 315	com/tencent/mm/plugin/finder/live/report/q$n:scene	Ljava/lang/String;
    //   293: invokevirtual 323	com/tencent/mm/plugin/finder/live/report/q:axz	(Ljava/lang/String;)V
    //   296: getstatic 292	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   299: astore 8
    //   301: getstatic 296	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   304: iload_2
    //   305: i2l
    //   306: putfield 326	com/tencent/mm/plugin/finder/live/report/q:Dpz	J
    //   309: getstatic 332	com/tencent/mm/ui/component/k:aeZF	Lcom/tencent/mm/ui/component/k;
    //   312: astore 8
    //   314: new 334	com/tencent/mm/ad/i
    //   317: dup
    //   318: aload 10
    //   320: invokestatic 338	com/tencent/mm/ui/component/k:nq	(Landroid/content/Context;)Lcom/tencent/mm/ui/component/k$b;
    //   323: ldc_w 340
    //   326: invokevirtual 346	com/tencent/mm/ui/component/k$b:cq	(Ljava/lang/Class;)Lcom/tencent/mm/ui/component/c;
    //   329: checkcast 340	com/tencent/mm/plugin/findersdk/a/bn
    //   332: invokeinterface 349 1 0
    //   337: ldc_w 351
    //   340: ldc_w 353
    //   343: invokestatic 359	kotlin/n/n:bV	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   346: invokespecial 360	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
    //   349: astore 8
    //   351: aload 8
    //   353: ldc_w 362
    //   356: invokevirtual 366	com/tencent/mm/ad/i:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   359: pop
    //   360: aload 8
    //   362: ldc_w 368
    //   365: invokevirtual 366	com/tencent/mm/ad/i:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   368: pop
    //   369: aload 8
    //   371: ldc_w 370
    //   374: invokevirtual 366	com/tencent/mm/ad/i:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   377: pop
    //   378: getstatic 332	com/tencent/mm/ui/component/k:aeZF	Lcom/tencent/mm/ui/component/k;
    //   381: astore 9
    //   383: aload 10
    //   385: invokestatic 338	com/tencent/mm/ui/component/k:nq	(Landroid/content/Context;)Lcom/tencent/mm/ui/component/k$b;
    //   388: ldc_w 340
    //   391: invokevirtual 346	com/tencent/mm/ui/component/k$b:cq	(Ljava/lang/Class;)Lcom/tencent/mm/ui/component/c;
    //   394: checkcast 340	com/tencent/mm/plugin/findersdk/a/bn
    //   397: astore 9
    //   399: aload 8
    //   401: invokevirtual 371	com/tencent/mm/ad/i:toString	()Ljava/lang/String;
    //   404: astore 8
    //   406: aload 8
    //   408: ldc_w 373
    //   411: invokestatic 286	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   414: aload 9
    //   416: aload 8
    //   418: ldc_w 353
    //   421: ldc_w 351
    //   424: invokestatic 359	kotlin/n/n:bV	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   427: invokeinterface 376 2 0
    //   432: aload_0
    //   433: getfield 88	com/tencent/mm/plugin/finder/live/i:pos	I
    //   436: istore 6
    //   438: aload_0
    //   439: getfield 105	com/tencent/mm/plugin/finder/live/i:Bxq	Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;
    //   442: astore 8
    //   444: aload_0
    //   445: getfield 86	com/tencent/mm/plugin/finder/live/i:TAG	Ljava/lang/String;
    //   448: ldc_w 378
    //   451: aload_0
    //   452: getfield 88	com/tencent/mm/plugin/finder/live/i:pos	I
    //   455: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: invokestatic 263	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   461: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload 8
    //   466: ifnull +57 -> 523
    //   469: aload 8
    //   471: iconst_0
    //   472: invokevirtual 387	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:reset	(Z)V
    //   475: aload 8
    //   477: invokevirtual 390	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:unMount	()V
    //   480: aload 8
    //   482: invokevirtual 394	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:getParent	()Landroid/view/ViewParent;
    //   485: astore 8
    //   487: aload 8
    //   489: instanceof 396
    //   492: ifeq +482 -> 974
    //   495: aload 8
    //   497: checkcast 396	com/tencent/mm/ui/widget/RoundedCornerFrameLayout
    //   500: astore 8
    //   502: aload 8
    //   504: ifnull +19 -> 523
    //   507: aload 8
    //   509: aload 8
    //   511: invokevirtual 397	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:getContext	()Landroid/content/Context;
    //   514: bipush 8
    //   516: invokestatic 403	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   519: i2f
    //   520: invokevirtual 407	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setRadius	(F)V
    //   523: aload_0
    //   524: getfield 86	com/tencent/mm/plugin/finder/live/i:TAG	Ljava/lang/String;
    //   527: ldc_w 409
    //   530: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload_0
    //   534: aload_1
    //   535: putfield 105	com/tencent/mm/plugin/finder/live/i:Bxq	Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;
    //   538: aload_0
    //   539: iload_2
    //   540: putfield 88	com/tencent/mm/plugin/finder/live/i:pos	I
    //   543: aload_0
    //   544: getfield 105	com/tencent/mm/plugin/finder/live/i:Bxq	Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;
    //   547: astore 9
    //   549: aload_0
    //   550: getfield 86	com/tencent/mm/plugin/finder/live/i:TAG	Ljava/lang/String;
    //   553: astore 10
    //   555: new 199	java/lang/StringBuilder
    //   558: dup
    //   559: ldc_w 411
    //   562: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   565: aload_0
    //   566: getfield 88	com/tencent/mm/plugin/finder/live/i:pos	I
    //   569: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: ldc_w 413
    //   575: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: astore 11
    //   580: aload_3
    //   581: ifnonnull +399 -> 980
    //   584: aconst_null
    //   585: astore 8
    //   587: aload 10
    //   589: aload 11
    //   591: aload 8
    //   593: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   602: aload_3
    //   603: ifnull +131 -> 734
    //   606: aload 9
    //   608: ifnull +126 -> 734
    //   611: getstatic 147	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   614: astore 8
    //   616: aload_3
    //   617: invokestatic 419	com/tencent/mm/plugin/finder/live/model/aj:a	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/f;)Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   620: astore 8
    //   622: aload 8
    //   624: ifnull +110 -> 734
    //   627: getstatic 147	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   630: aload 8
    //   632: aload 9
    //   634: checkcast 421	com/tencent/mm/plugin/finder/live/view/a
    //   637: iconst_0
    //   638: aload_0
    //   639: getfield 82	com/tencent/mm/plugin/finder/live/i:reportObj	Lcom/tencent/mm/protocal/protobuf/bui;
    //   642: iconst_4
    //   643: invokestatic 424	com/tencent/mm/plugin/finder/live/model/aj:a	(Lcom/tencent/mm/plugin/finder/live/model/aj;Lcom/tencent/mm/plugin/finder/live/model/context/a;Lcom/tencent/mm/plugin/finder/live/view/a;ILcom/tencent/mm/protocal/protobuf/bui;I)V
    //   646: aload 9
    //   648: aload_3
    //   649: iload 4
    //   651: iload 5
    //   653: invokevirtual 428	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:activate	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/f;ZZ)V
    //   656: aload 9
    //   658: invokevirtual 431	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:mount	()V
    //   661: getstatic 332	com/tencent/mm/ui/component/k:aeZF	Lcom/tencent/mm/ui/component/k;
    //   664: astore 8
    //   666: aload 9
    //   668: invokevirtual 160	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:getContext	()Landroid/content/Context;
    //   671: astore 8
    //   673: aload 8
    //   675: ldc_w 433
    //   678: invokestatic 286	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   681: aload 8
    //   683: invokestatic 338	com/tencent/mm/ui/component/k:nq	(Landroid/content/Context;)Lcom/tencent/mm/ui/component/k$b;
    //   686: ldc_w 435
    //   689: invokevirtual 438	com/tencent/mm/ui/component/k$b:q	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   692: checkcast 435	com/tencent/mm/plugin/finder/live/sidebar/d
    //   695: getfield 441	com/tencent/mm/plugin/finder/live/sidebar/d:DGD	Z
    //   698: ifne +36 -> 734
    //   701: aload 9
    //   703: invokevirtual 394	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:getParent	()Landroid/view/ViewParent;
    //   706: astore 8
    //   708: aload 8
    //   710: instanceof 396
    //   713: ifeq +276 -> 989
    //   716: aload 8
    //   718: checkcast 396	com/tencent/mm/ui/widget/RoundedCornerFrameLayout
    //   721: astore 8
    //   723: aload 8
    //   725: ifnull +9 -> 734
    //   728: aload 8
    //   730: fconst_0
    //   731: invokevirtual 407	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setRadius	(F)V
    //   734: aload_0
    //   735: getfield 86	com/tencent/mm/plugin/finder/live/i:TAG	Ljava/lang/String;
    //   738: ldc_w 443
    //   741: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   744: getstatic 449	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   747: new 451	com/tencent/mm/plugin/finder/live/i$$ExternalSyntheticLambda0
    //   750: dup
    //   751: aload_0
    //   752: iload 6
    //   754: iload_2
    //   755: aload_3
    //   756: invokespecial 453	com/tencent/mm/plugin/finder/live/i$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/finder/live/i;IILcom/tencent/mm/plugin/finder/live/viewmodel/data/f;)V
    //   759: invokeinterface 459 2 0
    //   764: pop
    //   765: getstatic 239	com/tencent/mm/plugin/finder/utils/bd:Gli	Lcom/tencent/mm/plugin/finder/utils/bd;
    //   768: astore_3
    //   769: invokestatic 242	com/tencent/mm/plugin/finder/utils/bd:fhS	()Ljava/lang/String;
    //   772: aload_1
    //   773: invokevirtual 246	com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout:getData	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/f;
    //   776: getfield 250	com/tencent/mm/plugin/finder/live/viewmodel/data/f:Ebr	Lcom/tencent/mm/live/api/LiveConfig;
    //   779: getfield 253	com/tencent/mm/live/api/LiveConfig:liveId	J
    //   782: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   785: invokestatic 263	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   788: astore_1
    //   789: getstatic 269	com/tencent/mm/plugin/finder/utils/bb:GjM	Lcom/tencent/mm/plugin/finder/utils/bb$a;
    //   792: astore 8
    //   794: aload_3
    //   795: aload_1
    //   796: invokestatic 462	com/tencent/mm/plugin/finder/utils/bb:fhg	()Lcom/tencent/mm/plugin/finder/utils/bb$c;
    //   799: getfield 278	com/tencent/mm/plugin/finder/utils/bb$c:name	Ljava/lang/String;
    //   802: aconst_null
    //   803: iconst_0
    //   804: iconst_0
    //   805: iconst_0
    //   806: bipush 60
    //   808: invokestatic 281	com/tencent/mm/plugin/finder/utils/bd:a	(Lcom/tencent/mm/plugin/finder/utils/bd;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/bx/b;ZZZI)V
    //   811: aload_0
    //   812: getfield 86	com/tencent/mm/plugin/finder/live/i:TAG	Ljava/lang/String;
    //   815: ldc_w 464
    //   818: aload_0
    //   819: getfield 88	com/tencent/mm/plugin/finder/live/i:pos	I
    //   822: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   825: invokestatic 263	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   828: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: ldc 196
    //   833: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   836: return
    //   837: iconst_0
    //   838: istore 7
    //   840: goto -668 -> 172
    //   843: aload_3
    //   844: getfield 250	com/tencent/mm/plugin/finder/live/viewmodel/data/f:Ebr	Lcom/tencent/mm/live/api/LiveConfig;
    //   847: astore 8
    //   849: aload 8
    //   851: ifnonnull +9 -> 860
    //   854: aconst_null
    //   855: astore 9
    //   857: goto -619 -> 238
    //   860: aload 8
    //   862: getfield 467	com/tencent/mm/live/api/LiveConfig:sessionBuffer	Ljava/lang/String;
    //   865: astore 9
    //   867: goto -629 -> 238
    //   870: aload_3
    //   871: getfield 166	com/tencent/mm/plugin/finder/live/viewmodel/data/f:BxG	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   874: astore 8
    //   876: aload 8
    //   878: ifnonnull +10 -> 888
    //   881: ldc 109
    //   883: astore 8
    //   885: goto -630 -> 255
    //   888: aload 8
    //   890: ldc 168
    //   892: invokevirtual 174	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   895: checkcast 168	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   898: astore 8
    //   900: aload 8
    //   902: ifnonnull +10 -> 912
    //   905: ldc 109
    //   907: astore 8
    //   909: goto -654 -> 255
    //   912: aload 8
    //   914: getfield 471	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Eco	Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   917: astore 8
    //   919: aload 8
    //   921: ifnonnull +10 -> 931
    //   924: ldc 109
    //   926: astore 8
    //   928: goto -673 -> 255
    //   931: aload 8
    //   933: getfield 474	com/tencent/mm/protocal/protobuf/FinderObject:sessionBuffer	Ljava/lang/String;
    //   936: astore 9
    //   938: aload 9
    //   940: astore 8
    //   942: aload 9
    //   944: ifnonnull -689 -> 255
    //   947: ldc 109
    //   949: astore 8
    //   951: goto -696 -> 255
    //   954: astore 8
    //   956: aload_0
    //   957: getfield 86	com/tencent/mm/plugin/finder/live/i:TAG	Ljava/lang/String;
    //   960: ldc_w 476
    //   963: aload 8
    //   965: invokestatic 263	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   968: invokestatic 479	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   971: goto -539 -> 432
    //   974: aconst_null
    //   975: astore 8
    //   977: goto -475 -> 502
    //   980: aload_3
    //   981: invokevirtual 482	com/tencent/mm/plugin/finder/live/viewmodel/data/f:exV	()Ljava/lang/String;
    //   984: astore 8
    //   986: goto -399 -> 587
    //   989: aconst_null
    //   990: astore 8
    //   992: goto -269 -> 723
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	995	0	this	i
    //   0	995	1	paramFinderLiveVisitorPluginLayout	FinderLiveVisitorPluginLayout
    //   0	995	2	paramInt	int
    //   0	995	3	paramf	com.tencent.mm.plugin.finder.live.viewmodel.data.f
    //   0	995	4	paramBoolean1	boolean
    //   0	995	5	paramBoolean2	boolean
    //   56	697	6	i	int
    //   170	669	7	bool	boolean
    //   15	935	8	localObject1	Object
    //   954	10	8	localObject2	Object
    //   975	16	8	str	String
    //   38	905	9	localObject3	Object
    //   44	544	10	localObject4	Object
    //   229	361	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   309	432	954	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.i
 * JD-Core Version:    0.7.0.1
 */