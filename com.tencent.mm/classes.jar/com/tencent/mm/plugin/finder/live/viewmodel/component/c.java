package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.cf;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  public static final a Eap;
  
  static
  {
    AppMethodBeat.i(356918);
    Eap = new a((byte)0);
    AppMethodBeat.o(356918);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356892);
    AppMethodBeat.o(356892);
  }
  
  private static final void a(c paramc, bjc parambjc, long paramLong, bui parambui, String paramString, View paramView)
  {
    AppMethodBeat.i(356911);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(parambjc);
    localb.hB(paramLong);
    localb.cH(parambui);
    localb.cH(paramString);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    localObject = d.FAy;
    if (((Number)d.eTo().bmg()).intValue() <= 0)
    {
      aa.makeText(paramView.getContext(), (CharSequence)paramView.getContext().getResources().getString(p.h.Cgw), 0).show();
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(356911);
      return;
    }
    paramView = new bjb();
    paramView.username = paramString;
    paramView.ZPU = false;
    paramString = (f)h.ax(f.class);
    localObject = (Context)paramc.getActivity();
    paramc = parambjc.ZSM;
    if (paramc == null) {}
    for (int i = 0;; i = paramc.abgH)
    {
      parambjc = parambjc.id;
      paramc = parambjc;
      if (parambjc == null) {
        paramc = "";
      }
      paramString.a((Context)localObject, i, paramView, paramc, paramLong, parambui, false);
      k.a(k.Doi, q.cf.DFn, "");
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(356911);
      return;
    }
  }
  
  private static final boolean a(MMActivity paramMMActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(356899);
    s.u(paramMMActivity, "$this_run");
    paramMMActivity.finish();
    AppMethodBeat.o(356899);
    return true;
  }
  
  public final int getLayoutId()
  {
    return p.f.Cer;
  }
  
  /* Error */
  public final void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 239
    //   5: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 241	com/tencent/mm/ui/component/UIComponent:onCreate	(Landroid/os/Bundle;)V
    //   13: aload_0
    //   14: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   17: checkcast 229	com/tencent/mm/ui/MMActivity
    //   20: astore_1
    //   21: aload_1
    //   22: getstatic 244	com/tencent/mm/plugin/finder/live/p$h:Coo	I
    //   25: invokevirtual 247	com/tencent/mm/ui/MMActivity:setMMTitle	(I)V
    //   28: aload_1
    //   29: new 249	com/tencent/mm/plugin/finder/live/viewmodel/component/c$$ExternalSyntheticLambda0
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 252	com/tencent/mm/plugin/finder/live/viewmodel/component/c$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/ui/MMActivity;)V
    //   37: invokevirtual 256	com/tencent/mm/ui/MMActivity:setBackBtn	(Landroid/view/MenuItem$OnMenuItemClickListener;)V
    //   40: aload_0
    //   41: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   44: invokevirtual 262	androidx/appcompat/app/AppCompatActivity:getIntent	()Landroid/content/Intent;
    //   47: ldc_w 264
    //   50: invokevirtual 270	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 7
    //   55: aload_0
    //   56: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   59: invokevirtual 262	androidx/appcompat/app/AppCompatActivity:getIntent	()Landroid/content/Intent;
    //   62: ldc_w 272
    //   65: invokevirtual 276	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   68: astore 6
    //   70: aload 6
    //   72: ifnonnull +46 -> 118
    //   75: aconst_null
    //   76: astore 6
    //   78: aload_0
    //   79: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   82: invokevirtual 262	androidx/appcompat/app/AppCompatActivity:getIntent	()Landroid/content/Intent;
    //   85: ldc_w 278
    //   88: lconst_0
    //   89: invokevirtual 282	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   92: lstore_3
    //   93: aload 6
    //   95: ifnonnull +67 -> 162
    //   98: aload 5
    //   100: astore_1
    //   101: aload_1
    //   102: ifnonnull +10 -> 112
    //   105: aload_0
    //   106: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   109: invokevirtual 283	androidx/appcompat/app/AppCompatActivity:finish	()V
    //   112: ldc 239
    //   114: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: new 193	com/tencent/mm/protocal/protobuf/bjc
    //   121: dup
    //   122: invokespecial 284	com/tencent/mm/protocal/protobuf/bjc:<init>	()V
    //   125: astore_1
    //   126: aload_1
    //   127: aload 6
    //   129: invokevirtual 288	com/tencent/mm/protocal/protobuf/bjc:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   132: pop
    //   133: aload_1
    //   134: astore 6
    //   136: goto -58 -> 78
    //   139: astore_1
    //   140: ldc_w 290
    //   143: ldc_w 292
    //   146: iconst_1
    //   147: anewarray 73	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: aastore
    //   154: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aconst_null
    //   158: astore_1
    //   159: goto -26 -> 133
    //   162: getstatic 304	com/tencent/mm/plugin/finder/api/d:AwY	Lcom/tencent/mm/plugin/finder/api/d$a;
    //   165: astore_1
    //   166: aload 7
    //   168: invokestatic 310	com/tencent/mm/plugin/finder/api/d$a:auT	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/api/m;
    //   171: astore 8
    //   173: aload_0
    //   174: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   177: invokevirtual 311	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   180: getstatic 314	com/tencent/mm/plugin/finder/live/p$h:CmE	I
    //   183: invokevirtual 152	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   186: astore 5
    //   188: aload 5
    //   190: ldc_w 316
    //   193: invokestatic 319	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   196: aload 5
    //   198: astore_1
    //   199: aload 8
    //   201: ifnull +33 -> 234
    //   204: new 321	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   211: aload 5
    //   213: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: sipush 183
    //   219: invokevirtual 329	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   222: aload 8
    //   224: invokevirtual 335	com/tencent/mm/plugin/finder/api/m:getNickname	()Ljava/lang/String;
    //   227: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore_1
    //   234: aload_0
    //   235: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   238: getstatic 343	com/tencent/mm/plugin/finder/live/p$e:BXC	I
    //   241: invokevirtual 347	androidx/appcompat/app/AppCompatActivity:findViewById	(I)Landroid/view/View;
    //   244: checkcast 349	android/widget/TextView
    //   247: aload_1
    //   248: checkcast 154	java/lang/CharSequence
    //   251: invokevirtual 353	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   254: aload 6
    //   256: getfield 356	com/tencent/mm/protocal/protobuf/bjc:description	Ljava/lang/String;
    //   259: checkcast 154	java/lang/CharSequence
    //   262: astore_1
    //   263: aload_1
    //   264: ifnull +12 -> 276
    //   267: aload_1
    //   268: invokeinterface 359 1 0
    //   273: ifne +341 -> 614
    //   276: iconst_1
    //   277: istore_2
    //   278: iload_2
    //   279: ifeq +340 -> 619
    //   282: aload_0
    //   283: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   286: getstatic 362	com/tencent/mm/plugin/finder/live/p$e:BXx	I
    //   289: invokevirtual 347	androidx/appcompat/app/AppCompatActivity:findViewById	(I)Landroid/view/View;
    //   292: bipush 8
    //   294: invokevirtual 365	android/view/View:setVisibility	(I)V
    //   297: aload_0
    //   298: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   301: getstatic 368	com/tencent/mm/plugin/finder/live/p$e:BXz	I
    //   304: invokevirtual 347	androidx/appcompat/app/AppCompatActivity:findViewById	(I)Landroid/view/View;
    //   307: checkcast 349	android/widget/TextView
    //   310: aload 6
    //   312: getfield 356	com/tencent/mm/protocal/protobuf/bjc:description	Ljava/lang/String;
    //   315: checkcast 154	java/lang/CharSequence
    //   318: invokevirtual 353	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   321: aload 6
    //   323: getfield 372	com/tencent/mm/protocal/protobuf/bjc:ZQa	Lcom/tencent/mm/protocal/protobuf/bja;
    //   326: astore_1
    //   327: aload_1
    //   328: ifnonnull +308 -> 636
    //   331: aconst_null
    //   332: astore_1
    //   333: aload_1
    //   334: ifnonnull +313 -> 647
    //   337: aload_1
    //   338: ifnonnull +322 -> 660
    //   341: iconst_0
    //   342: istore_2
    //   343: iload_2
    //   344: ifeq +405 -> 749
    //   347: aload 6
    //   349: getfield 372	com/tencent/mm/protocal/protobuf/bjc:ZQa	Lcom/tencent/mm/protocal/protobuf/bja;
    //   352: astore_1
    //   353: aload_1
    //   354: ifnonnull +319 -> 673
    //   357: aconst_null
    //   358: astore_1
    //   359: aload_1
    //   360: astore 5
    //   362: aload_1
    //   363: ifnonnull +21 -> 384
    //   366: aload_0
    //   367: checkcast 2	com/tencent/mm/plugin/finder/live/viewmodel/component/c
    //   370: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   373: invokevirtual 311	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   376: getstatic 375	com/tencent/mm/plugin/finder/live/p$h:CmK	I
    //   379: invokevirtual 152	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   382: astore 5
    //   384: aload 5
    //   386: ldc_w 377
    //   389: invokestatic 319	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   392: aload_0
    //   393: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   396: getstatic 380	com/tencent/mm/plugin/finder/live/p$e:BXB	I
    //   399: invokevirtual 347	androidx/appcompat/app/AppCompatActivity:findViewById	(I)Landroid/view/View;
    //   402: checkcast 349	android/widget/TextView
    //   405: aload 5
    //   407: checkcast 154	java/lang/CharSequence
    //   410: invokevirtual 353	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   413: aload_0
    //   414: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   417: getstatic 383	com/tencent/mm/plugin/finder/live/p$e:BXy	I
    //   420: invokevirtual 347	androidx/appcompat/app/AppCompatActivity:findViewById	(I)Landroid/view/View;
    //   423: checkcast 349	android/widget/TextView
    //   426: aload_0
    //   427: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   430: invokevirtual 311	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   433: getstatic 386	com/tencent/mm/plugin/finder/live/p$h:CmD	I
    //   436: iconst_1
    //   437: anewarray 73	java/lang/Object
    //   440: dup
    //   441: iconst_0
    //   442: aload 6
    //   444: getfield 389	com/tencent/mm/protocal/protobuf/bjc:Czn	I
    //   447: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   450: aastore
    //   451: invokevirtual 398	android/content/res/Resources:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   454: checkcast 154	java/lang/CharSequence
    //   457: invokevirtual 353	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   460: aload_0
    //   461: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   464: getstatic 401	com/tencent/mm/plugin/finder/live/p$e:BXA	I
    //   467: invokevirtual 347	androidx/appcompat/app/AppCompatActivity:findViewById	(I)Landroid/view/View;
    //   470: checkcast 349	android/widget/TextView
    //   473: ldc_w 403
    //   476: aload 6
    //   478: getfield 406	com/tencent/mm/protocal/protobuf/bjc:endTime	I
    //   481: i2l
    //   482: invokestatic 412	com/tencent/mm/pluginsdk/platformtools/f:formatTime	(Ljava/lang/String;J)Ljava/lang/String;
    //   485: checkcast 154	java/lang/CharSequence
    //   488: invokevirtual 353	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   491: ldc_w 414
    //   494: invokestatic 187	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   497: checkcast 414	com/tencent/mm/plugin/h
    //   500: aload_0
    //   501: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   504: checkcast 229	com/tencent/mm/ui/MMActivity
    //   507: checkcast 136	android/content/Context
    //   510: invokeinterface 418 2 0
    //   515: astore_1
    //   516: aload_1
    //   517: ifnonnull +299 -> 816
    //   520: aconst_null
    //   521: astore_1
    //   522: getstatic 424	com/tencent/mm/plugin/finder/report/f:FnM	Lcom/tencent/mm/plugin/finder/report/f;
    //   525: astore 5
    //   527: invokestatic 428	com/tencent/mm/plugin/finder/report/f:eMn	()Lcom/tencent/mm/plugin/finder/report/f$b;
    //   530: astore 8
    //   532: invokestatic 433	com/tencent/mm/model/z:bAW	()Ljava/lang/String;
    //   535: astore 9
    //   537: aload 9
    //   539: ldc_w 435
    //   542: invokestatic 319	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   545: aload 7
    //   547: ifnonnull +279 -> 826
    //   550: ldc 201
    //   552: astore 5
    //   554: aload 8
    //   556: aload 9
    //   558: ldc 201
    //   560: aload 5
    //   562: invokevirtual 441	com/tencent/mm/plugin/finder/report/f$b:ak	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   565: getstatic 424	com/tencent/mm/plugin/finder/report/f:FnM	Lcom/tencent/mm/plugin/finder/report/f;
    //   568: astore 5
    //   570: invokestatic 428	com/tencent/mm/plugin/finder/report/f:eMn	()Lcom/tencent/mm/plugin/finder/report/f$b;
    //   573: aload_1
    //   574: ldc2_w 442
    //   577: invokestatic 446	com/tencent/mm/plugin/finder/report/f$b:a	(Lcom/tencent/mm/plugin/finder/report/f$b;Lcom/tencent/mm/protocal/protobuf/bui;J)V
    //   580: aload_0
    //   581: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   584: getstatic 449	com/tencent/mm/plugin/finder/live/p$e:BXJ	I
    //   587: invokevirtual 347	androidx/appcompat/app/AppCompatActivity:findViewById	(I)Landroid/view/View;
    //   590: new 451	com/tencent/mm/plugin/finder/live/viewmodel/component/c$$ExternalSyntheticLambda1
    //   593: dup
    //   594: aload_0
    //   595: aload 6
    //   597: lload_3
    //   598: aload_1
    //   599: aload 7
    //   601: invokespecial 454	com/tencent/mm/plugin/finder/live/viewmodel/component/c$$ExternalSyntheticLambda1:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/component/c;Lcom/tencent/mm/protocal/protobuf/bjc;JLcom/tencent/mm/protocal/protobuf/bui;Ljava/lang/String;)V
    //   604: invokevirtual 458	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   607: getstatic 464	kotlin/ah:aiuX	Lkotlin/ah;
    //   610: astore_1
    //   611: goto -510 -> 101
    //   614: iconst_0
    //   615: istore_2
    //   616: goto -338 -> 278
    //   619: aload_0
    //   620: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   623: getstatic 362	com/tencent/mm/plugin/finder/live/p$e:BXx	I
    //   626: invokevirtual 347	androidx/appcompat/app/AppCompatActivity:findViewById	(I)Landroid/view/View;
    //   629: iconst_0
    //   630: invokevirtual 365	android/view/View:setVisibility	(I)V
    //   633: goto -336 -> 297
    //   636: aload_1
    //   637: getfield 469	com/tencent/mm/protocal/protobuf/bja:ZSK	I
    //   640: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   643: astore_1
    //   644: goto -311 -> 333
    //   647: aload_1
    //   648: invokevirtual 470	java/lang/Integer:intValue	()I
    //   651: iconst_1
    //   652: if_icmpne -315 -> 337
    //   655: iconst_1
    //   656: istore_2
    //   657: goto -314 -> 343
    //   660: aload_1
    //   661: invokevirtual 470	java/lang/Integer:intValue	()I
    //   664: iconst_3
    //   665: if_icmpne -324 -> 341
    //   668: iconst_1
    //   669: istore_2
    //   670: goto -327 -> 343
    //   673: aload_1
    //   674: getfield 473	com/tencent/mm/protocal/protobuf/bja:CJJ	Ljava/lang/String;
    //   677: astore_1
    //   678: aload_1
    //   679: ifnonnull +8 -> 687
    //   682: aconst_null
    //   683: astore_1
    //   684: goto -325 -> 359
    //   687: aload_1
    //   688: checkcast 154	java/lang/CharSequence
    //   691: invokeinterface 359 1 0
    //   696: ifle +18 -> 714
    //   699: iconst_1
    //   700: istore_2
    //   701: iload_2
    //   702: ifeq +17 -> 719
    //   705: aload_1
    //   706: ifnonnull +18 -> 724
    //   709: aconst_null
    //   710: astore_1
    //   711: goto -352 -> 359
    //   714: iconst_0
    //   715: istore_2
    //   716: goto -15 -> 701
    //   719: aconst_null
    //   720: astore_1
    //   721: goto -16 -> 705
    //   724: aload_0
    //   725: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   728: invokevirtual 311	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   731: getstatic 476	com/tencent/mm/plugin/finder/live/p$h:Cmz	I
    //   734: iconst_1
    //   735: anewarray 73	java/lang/Object
    //   738: dup
    //   739: iconst_0
    //   740: aload_1
    //   741: aastore
    //   742: invokevirtual 398	android/content/res/Resources:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   745: astore_1
    //   746: goto -387 -> 359
    //   749: aload_1
    //   750: ifnonnull +14 -> 764
    //   753: aload_1
    //   754: ifnonnull +36 -> 790
    //   757: ldc 201
    //   759: astore 5
    //   761: goto -377 -> 384
    //   764: aload_1
    //   765: invokevirtual 470	java/lang/Integer:intValue	()I
    //   768: iconst_2
    //   769: if_icmpne -16 -> 753
    //   772: aload_0
    //   773: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   776: invokevirtual 311	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   779: getstatic 479	com/tencent/mm/plugin/finder/live/p$h:CmL	I
    //   782: invokevirtual 152	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   785: astore 5
    //   787: goto -403 -> 384
    //   790: aload_1
    //   791: invokevirtual 470	java/lang/Integer:intValue	()I
    //   794: iconst_4
    //   795: if_icmpne -38 -> 757
    //   798: aload_0
    //   799: invokevirtual 191	com/tencent/mm/plugin/finder/live/viewmodel/component/c:getActivity	()Landroidx/appcompat/app/AppCompatActivity;
    //   802: invokevirtual 311	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   805: getstatic 482	com/tencent/mm/plugin/finder/live/p$h:Cmv	I
    //   808: invokevirtual 152	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   811: astore 5
    //   813: goto -429 -> 384
    //   816: aload_1
    //   817: invokeinterface 488 1 0
    //   822: astore_1
    //   823: goto -301 -> 522
    //   826: aload 7
    //   828: astore 5
    //   830: goto -276 -> 554
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	c
    //   0	833	1	paramBundle	android.os.Bundle
    //   277	439	2	i	int
    //   92	506	3	l	long
    //   1	828	5	localObject1	Object
    //   68	528	6	localObject2	Object
    //   53	774	7	str1	String
    //   171	384	8	localObject3	Object
    //   535	22	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   126	133	139	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC$Companion;", "", "()V", "KEY_LOTTERY_HISTORY_DETAIL_INFO", "", "KEY_LOTTERY_HISTORY_OBJECT_ID", "TAG", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.c
 * JD-Core Version:    0.7.0.1
 */