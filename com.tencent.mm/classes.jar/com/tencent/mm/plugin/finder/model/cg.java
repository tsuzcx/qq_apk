package com.tencent.mm.plugin.finder.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.finder.utils.ar.a;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.i;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.as;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/SyncGetImageModel;", "Lcom/tencent/mm/ui/component/CoroutineViewModel;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "curJob", "Lkotlinx/coroutines/Job;", "getCurJob", "()Lkotlinx/coroutines/Job;", "setCurJob", "(Lkotlinx/coroutines/Job;)V", "hotFireIconColor", "", "getHotFireIconColor", "()I", "setHotFireIconColor", "(I)V", "hotFireIconSize", "getHotFireIconSize", "setHotFireIconSize", "isIconsFilled", "", "()Z", "setIconsFilled", "(Z)V", "lastPos", "getLastPos", "setLastPos", "position", "getPosition", "setPosition", "analysisRichText", "Landroid/text/SpannableStringBuilder;", "richText", "", "incCount", "listener", "Lcom/tencent/mm/plugin/finder/utils/FinderTextUtils$AsyncGetDescText;", "cancel", "", "composeText", "name", "prefixText", "text", "formatDynamicDesc", "dynamicDesc", "iconInfos", "", "Lcom/tencent/mm/plugin/finder/model/SyncGetImageModel$DynamicIconInfo;", "iconDrawables", "Landroid/graphics/drawable/Drawable;", "getDescFromDynamicItem", "", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDynamicItem;", "count", "type", "getDescFromExtInfo", "getDescFromItems", "it", "nickName", "getDynamicIcons", "content", "getDynamicImage", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDynamicImage;", "getExtInfo", "getFireIconColor", "getFireIconSize", "getIconDrawable", "dynamicImage", "isIconFilled", "isTransparent", "getImage", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalDesc", "isNewsObject", "isExistItemConfig", "loadImages", "urls", "Lcom/tencent/mm/plugin/finder/model/SyncGetImageModel$ISyncLoadImageListener;", "mainLaunch", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "setDefaultDescText", "desc", "textView", "Landroid/widget/TextView;", "isMsgEventFeed", "setDefaultDrawerText", "setDesc", "totalCount", "feedId", "", "setDescSpan", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "iconList", "incStart", "setDrawerDesc", "setTextDesc", "Companion", "DynamicIconInfo", "ISyncLoadImageListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cg
  extends com.tencent.mm.ui.component.e
{
  public static final a EDV;
  private int Ahg = -1;
  private cb BdG;
  private boolean EDW;
  private int EDX;
  private int EDY;
  private Context context;
  int position;
  
  static
  {
    AppMethodBeat.i(332166);
    EDV = new a((byte)0);
    AppMethodBeat.o(332166);
  }
  
  private static bre Qu(int paramInt)
  {
    AppMethodBeat.i(332066);
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
    Iterator localIterator = ((Iterable)com.tencent.mm.plugin.finder.storage.logic.h.fat()).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((bre)localObject).ZZh == paramInt)
      {
        i = 1;
        label50:
        if (i == 0) {
          break label69;
        }
      }
    }
    for (;;)
    {
      localObject = (bre)localObject;
      AppMethodBeat.o(332066);
      return localObject;
      i = 0;
      break label50;
      label69:
      break;
      localObject = null;
    }
  }
  
  private final SpannableStringBuilder a(final Context paramContext, final String paramString, final int paramInt, final ar.a parama)
  {
    AppMethodBeat.i(332034);
    Object localObject2 = kotlin.n.k.b(new kotlin.n.k("<\\s*(?<name>\\w+)\\s*(?<attribute>\\w+)\\s*=\\s*(?<id>\\d+)\\s*/>"), (CharSequence)paramString);
    Object localObject1 = new ArrayList();
    localObject2 = ((kotlin.m.h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (i)((Iterator)localObject2).next();
      Log.i("Finder.SyncGetImageModel", ((i)localObject3).getValue() + "  " + ((i)localObject3).kBn());
      if (((i)localObject3).kBp().size() == 4) {
        ((ArrayList)localObject1).add(new cg.b(Integer.parseInt((String)((i)localObject3).kBp().get(3)), ((i)localObject3).kBn().fIj, ((i)localObject3).kBn().aixs));
      }
    }
    Object localObject3 = (List)localObject1;
    int i;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    int k;
    if (!((Collection)localObject3).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label455;
      }
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      i = 0;
      k = ((List)localObject3).size() - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localArrayList2.add(e(paramContext, false, true));
      localObject1 = Qu(((cg.b)((List)localObject3).get(i)).EDZ);
      if (aw.isDarkMode()) {
        if (localObject1 == null) {
          localObject1 = "";
        }
      }
      for (;;)
      {
        localArrayList1.add(localObject1);
        if (j <= k) {
          break label482;
        }
        localObject1 = a(paramInt, paramContext, paramString, (List)localObject3, (List)localArrayList2);
        localObject2 = (List)localArrayList1;
        paramString = (c)new d(this, paramInt, paramContext, paramString, (List)localObject3, parama);
        com.tencent.mm.ui.component.e.launch$default((com.tencent.mm.ui.component.e)this, null, null, (m)new i((List)localObject2, this, paramContext, paramString, null), 3, null);
        AppMethodBeat.o(332034);
        return localObject1;
        i = 0;
        break;
        localObject2 = ((bre)localObject1).ZZj;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = "";
          continue;
          if (localObject1 == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject2 = ((bre)localObject1).ZZi;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
        }
      }
      label455:
      parama.a(false, null);
      paramContext = a(paramInt, paramContext, paramString, (List)localObject3, null);
      AppMethodBeat.o(332034);
      return paramContext;
      label482:
      i = j;
    }
  }
  
  private final SpannableStringBuilder a(StringBuilder paramStringBuilder, List<cg.b> paramList, List<? extends Drawable> paramList1, int paramInt1, Context paramContext, int paramInt2)
  {
    AppMethodBeat.i(332075);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)paramStringBuilder);
    int k;
    if ((paramList != null) && (paramList1 != null))
    {
      k = paramList1.size() - 1;
      if (k < 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = (Drawable)paramList1.get(i);
      paramStringBuilder = (StringBuilder)localObject;
      if (localObject == null) {
        paramStringBuilder = null;
      }
      localObject = paramStringBuilder;
      if (paramStringBuilder == null) {
        localObject = e(paramContext, this.EDW, false);
      }
      localSpannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject, 1), ((cg.b)paramList.get(i)).EEa, ((cg.b)paramList.get(i)).EEb + 1, 17);
      if (j > k)
      {
        if (paramInt1 > 0) {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(e.b.Red)), paramInt2, localSpannableStringBuilder.length(), 17);
        }
        AppMethodBeat.o(332075);
        return localSpannableStringBuilder;
      }
    }
  }
  
  private final Object a(final TextView paramTextView, Context paramContext, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, brk parambrk, int paramInt3)
  {
    AppMethodBeat.i(332057);
    Object localObject;
    int i;
    if (parambrk == null)
    {
      paramTextView = null;
      if (paramTextView != null) {}
    }
    else
    {
      switch (paramInt3)
      {
      default: 
        AppMethodBeat.o(332057);
        return "";
        localObject = parambrk.nUC;
        if (localObject == null)
        {
          i = 0;
          label69:
          if (i <= 0) {
            break label450;
          }
        }
        break;
      }
    }
    for (;;)
    {
      try
      {
        ar.a locala = (ar.a)new l(this, paramTextView);
        paramTextView = parambrk.nUC.iterator();
        brf localbrf;
        if (paramTextView.hasNext())
        {
          localbrf = (brf)paramTextView.next();
          if (localbrf.name != paramInt3) {
            continue;
          }
          s.s(localbrf, "item");
        }
        switch (localbrf.type)
        {
        case 1: 
          paramTextView = (CharSequence)a(parambrk, paramInt3, paramInt1);
          break;
          i = ((LinkedList)localObject).size();
          break label69;
          Log.i("Finder.SyncGetImageModel", "item.type:" + localbrf.type + "  ConstantsFinder.FinderObjectDynamicConfig.DynamicItemType.TEXT:1");
          paramTextView = (CharSequence)String.valueOf(localbrf.text);
          break;
        case 2: 
          Log.i("Finder.SyncGetImageModel", "item.type:" + localbrf.type + "  ConstantsFinder.FinderObjectDynamicConfig.DynamicItemType.RICH_TEXT:2");
          paramTextView = localbrf.ZZk;
          if (paramTextView == null)
          {
            paramTextView = "";
            if (localbrf.name != 2) {
              continue;
            }
            paramTextView = s.X(paramString, paramTextView);
            paramTextView = (CharSequence)a(paramContext, paramTextView, paramInt2, locala);
            break;
          }
          localObject = n.m(paramTextView, "$$", String.valueOf(paramInt1), true);
          paramTextView = (TextView)localObject;
          if (localObject != null) {
            continue;
          }
          paramTextView = "";
          continue;
          paramTextView = paramString + ' ' + paramTextView;
          break;
        case 0: 
          paramTextView = (CharSequence)a(parambrk, paramInt3, paramInt1);
          break;
          paramTextView = null;
        }
      }
      catch (Exception paramTextView)
      {
        Log.printErrStackTrace("Finder.SyncGetImageModel", (Throwable)paramTextView, "setTextDesc", new Object[0]);
        e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "setTextDesc", false, null, false, (kotlin.g.a.a)m.EEq, 28);
        paramTextView = a(parambrk, paramInt3, paramInt1);
      }
      break;
      label450:
      paramTextView = a(parambrk, paramInt3, paramInt1);
      break;
      if (!paramBoolean) {}
      for (paramTextView = paramContext.getString(e.h.finder_real_name_recommend_desc2);; paramTextView = "")
      {
        s.s(paramTextView, "{\n            if (!isNew…\"\n            }\n        }");
        AppMethodBeat.o(332057);
        return paramTextView;
      }
      if (!paramBoolean) {}
      for (paramTextView = paramContext.getString(e.h.finder_real_name_recommend_desc1, new Object[] { String.valueOf(paramInt1) });; paramTextView = paramContext.getString(e.h.finder_real_name_recommend_desc2_news_1, new Object[] { String.valueOf(paramInt1) }))
      {
        s.s(paramTextView, "{\n            if (!isNew…)\n            }\n        }");
        AppMethodBeat.o(332057);
        return paramTextView;
      }
      paramTextView = paramContext.getString(e.h.finder_like_title_count_tip, new Object[] { "" });
      s.s(paramTextView, "{\n            context.ge…_count_tip, \"\")\n        }");
      AppMethodBeat.o(332057);
      return paramTextView;
      AppMethodBeat.o(332057);
      return paramTextView;
    }
  }
  
  private static String a(brk parambrk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(332040);
    switch (paramInt1)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          AppMethodBeat.o(332040);
          return "";
          parambrk = parambrk.ZZr;
          if (parambrk == null)
          {
            AppMethodBeat.o(332040);
            return "";
          }
          AppMethodBeat.o(332040);
          return parambrk;
          parambrk = parambrk.ZZs;
        } while (parambrk == null);
        parambrk = n.m(parambrk, "$$", String.valueOf(paramInt2), true);
      } while (parambrk == null);
      AppMethodBeat.o(332040);
      return parambrk;
    }
    parambrk = parambrk.ZZt;
    if (parambrk == null)
    {
      AppMethodBeat.o(332040);
      return "";
    }
    AppMethodBeat.o(332040);
    return parambrk;
  }
  
  private final cb a(f paramf, as paramas, m<? super aq, ? super d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(332018);
    paramf = l.b(getMainScope(), paramf, paramas, paramm);
    AppMethodBeat.o(332018);
    return paramf;
  }
  
  public static boolean a(brk parambrk)
  {
    AppMethodBeat.i(332009);
    if (parambrk != null)
    {
      parambrk = parambrk.nUC;
      if (parambrk != null)
      {
        parambrk = parambrk.iterator();
        while (parambrk.hasNext()) {
          if (((brf)parambrk.next()).name == 3)
          {
            AppMethodBeat.o(332009);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(332009);
    return false;
  }
  
  private Drawable e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(332087);
    s.u(paramContext, "context");
    if (paramBoolean2)
    {
      paramContext = (Drawable)new ColorDrawable(0);
      i = eDK();
      paramContext.setBounds(0, 0, i, i);
      s.s(paramContext, "icon");
      AppMethodBeat.o(332087);
      return paramContext;
    }
    if (paramBoolean1) {}
    for (int i = e.g.icons_filled_fire;; i = e.g.icons_outlined_fire)
    {
      paramContext = bb.m(paramContext, i, gJ(paramContext));
      break;
    }
  }
  
  private final int eDK()
  {
    AppMethodBeat.i(332102);
    if (this.EDY == -1)
    {
      ar localar = ar.Giw;
      i = ar.ffK();
      AppMethodBeat.o(332102);
      return i;
    }
    int i = this.EDY;
    AppMethodBeat.o(332102);
    return i;
  }
  
  private final int gJ(Context paramContext)
  {
    AppMethodBeat.i(332094);
    if (this.EDX == 0)
    {
      i = paramContext.getResources().getColor(e.b.White);
      AppMethodBeat.o(332094);
      return i;
    }
    int i = this.EDX;
    AppMethodBeat.o(332094);
    return i;
  }
  
  public final SpannableStringBuilder a(int paramInt, Context paramContext, String paramString, List<cg.b> paramList, List<? extends Drawable> paramList1)
  {
    AppMethodBeat.i(332177);
    s.u(paramContext, "context");
    s.u(paramString, "dynamicDesc");
    paramString = new StringBuilder(paramString);
    int i = paramString.length();
    if (paramInt > 0) {
      paramString.append("(+" + paramInt + ')');
    }
    paramContext = a(paramString, paramList, paramList1, paramInt, paramContext, i);
    AppMethodBeat.o(332177);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/SyncGetImageModel$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/SyncGetImageModel$ISyncLoadImageListener;", "", "onImages", "", "drawables", "", "Landroid/graphics/drawable/Drawable;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void hd(List<? extends Drawable> paramList);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/model/SyncGetImageModel$analysisRichText$1", "Lcom/tencent/mm/plugin/finder/model/SyncGetImageModel$ISyncLoadImageListener;", "onImages", "", "drawables", "", "Landroid/graphics/drawable/Drawable;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements cg.c
  {
    d(cg paramcg, int paramInt, Context paramContext, String paramString, List<cg.b> paramList, ar.a parama) {}
    
    public final void hd(List<? extends Drawable> paramList)
    {
      AppMethodBeat.i(332074);
      s.u(paramList, "drawables");
      paramList = this.EEc.a(paramInt, paramContext, paramString, this.EEf, paramList);
      parama.a(true, paramList);
      AppMethodBeat.o(332074);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f<T, R>
    implements com.tencent.mm.loader.e.e
  {
    f(cg paramcg, p<? super Drawable> paramp) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/model/SyncGetImageModel$getImage$2$4", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "imageFileBroken", "", "path", "", "objs", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.loader.e.b
  {
    h(p<? super Drawable> paramp) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    i(List<String> paramList, cg paramcg, Context paramContext, cg.c paramc, d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(332103);
      paramd = new i(this.EEh, jdField_this, paramContext, paramString, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(332103);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(332093);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      aq localaq;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(332093);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localaq = (aq)this.L$0;
        paramObject = new ArrayList();
        localObject1 = this.EEh.iterator();
      }
      Object localObject2;
      Object localObject3;
      Object localObject4;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = j.a(localaq, null, (m)new a(jdField_this, (String)localObject2, null), 3);
          localObject4 = (d)this;
          this.L$0 = localaq;
          this.Uf = paramObject;
          this.VC = localObject1;
          this.VD = localObject2;
          this.label = 1;
          localObject3 = ((ay)localObject3).e((d)localObject4);
          if (localObject3 != locala) {
            break label359;
          }
          AppMethodBeat.o(332093);
          return locala;
          localObject2 = (String)this.VD;
          localObject4 = (Iterator)this.VC;
          localObject3 = (ArrayList)this.Uf;
          localaq = (aq)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
          paramObject = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject4;
        }
      }
      label359:
      for (;;)
      {
        localObject3 = (Drawable)localObject3;
        Log.i("Finder.SyncGetImageModel", s.X("get drawable after wait url: ", localObject2));
        int i = cg.a(jdField_this);
        if (localObject3 != null)
        {
          localObject2 = jdField_this;
          localObject4 = paramContext;
          ((Drawable)localObject3).setBounds(0, 0, i, i);
          bb.e((Drawable)localObject3, cg.a((cg)localObject2, (Context)localObject4));
        }
        paramObject.add(localObject3);
        break;
        cg.a(jdField_this, (m)new kotlin.d.b.a.k(paramString, paramObject)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(332162);
            paramAnonymousObject = (d)new 1(this.EEi, paramObject, paramAnonymousd);
            AppMethodBeat.o(332162);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(332156);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(332156);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            this.EEi.hd((List)paramObject);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(332156);
            return paramAnonymousObject;
          }
        });
        paramObject = ah.aiuX;
        AppMethodBeat.o(332093);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, d<? super Drawable>, Object>
    {
      int label;
      
      a(cg paramcg, String paramString, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(332030);
        paramObject = (d)new a(this.EEc, this.mrs, paramd);
        AppMethodBeat.o(332030);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(332024);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(332024);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.EEc;
          Object localObject = this.mrs;
          d locald = (d)this;
          this.label = 1;
          localObject = cg.a(paramObject, (String)localObject, locald);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(332024);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(332024);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    j(cg paramcg, TextView paramTextView, Context paramContext, String paramString, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, brk parambrk, int paramInt3, d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(332086);
      paramObject = (d)new j(this.EEc, this.EEk, this.$context, this.EEl, this.EEm, this.EEn, this.EEd, this.EEo, this.EEp, this.eKn, paramd);
      AppMethodBeat.o(332086);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(332078);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(332078);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.EEc;
      localObject = this.EEk;
      Context localContext = this.$context;
      String str = this.EEl;
      boolean bool = this.EEm;
      int j = this.EEn;
      if ((this.EEd > 0) && (this.EEo)) {}
      for (int i = this.EEd;; i = 0)
      {
        paramObject = cg.a(paramObject, (TextView)localObject, localContext, str, bool, j, i, cg.b(this.EEp), this.eKn);
        cg.a(this.EEc, paramObject, this.EEk, this.EEd, this.EEo, this.EEl, this.$context, this.EEm);
        paramObject = ah.aiuX;
        AppMethodBeat.o(332078);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    k(cg paramcg, TextView paramTextView, Context paramContext, String paramString, boolean paramBoolean, int paramInt, brk parambrk, d<? super k> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(332060);
      paramObject = (d)new k(this.EEc, this.EEk, this.$context, this.EEl, this.EEm, this.amP, this.EEp, paramd);
      AppMethodBeat.o(332060);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(332050);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(332050);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = cg.a(this.EEc, this.EEk, this.$context, this.EEl, this.EEm, this.amP, 0, cg.b(this.EEp), 3);
      cg.a(this.EEc, paramObject, this.EEk, this.EEl, this.EEp, this.$context, this.EEm);
      paramObject = ah.aiuX;
      AppMethodBeat.o(332050);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/model/SyncGetImageModel$setTextDesc$desc$1$1", "Lcom/tencent/mm/plugin/finder/utils/FinderTextUtils$AsyncGetDescText;", "onGetDescText", "", "isNeedRefresh", "", "desc", "Landroid/text/SpannableStringBuilder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements ar.a
  {
    l(cg paramcg, TextView paramTextView) {}
    
    public final void a(boolean paramBoolean, SpannableStringBuilder paramSpannableStringBuilder)
    {
      AppMethodBeat.i(332041);
      Log.i("Finder.SyncGetImageModel", "onGetDescText type match isNeedRefresh:" + paramBoolean + ' ' + paramSpannableStringBuilder + " pos:" + this.EEc.position + " hashCode:" + hashCode());
      if ((paramBoolean) && (paramSpannableStringBuilder != null)) {
        paramTextView.setText((CharSequence)paramSpannableStringBuilder);
      }
      AppMethodBeat.o(332041);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final m EEq;
    
    static
    {
      AppMethodBeat.i(332039);
      EEq = new m();
      AppMethodBeat.o(332039);
    }
    
    m()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.cg
 * JD-Core Version:    0.7.0.1
 */