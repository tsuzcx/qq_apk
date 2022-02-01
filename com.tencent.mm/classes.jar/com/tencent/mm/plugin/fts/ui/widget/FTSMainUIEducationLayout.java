package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.appbrand.service.x.a;
import com.tencent.mm.plugin.appbrand.service.x.b;
import com.tencent.mm.plugin.fts.ui.b.l;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.o.a;
import com.tencent.mm.plugin.fts.ui.o.b;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.f;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class FTSMainUIEducationLayout
  extends LinearLayout
{
  protected View.OnClickListener BOf;
  protected List<LinearLayout> BRb;
  protected HashMap<String, WeakReference<View>> BRc;
  protected Map<Integer, TextView> BRd;
  private String BRe;
  private boolean BRf;
  protected boolean BRg;
  private boolean BRh;
  boolean BRi;
  public View.OnClickListener BRj;
  private View.OnClickListener BRk;
  private float pEE;
  
  public FTSMainUIEducationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112267);
    this.BRc = new HashMap();
    this.BRd = new HashMap();
    this.BRe = "";
    this.pEE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.BRf = true;
    this.BRg = true;
    this.BRi = false;
    initView();
    AppMethodBeat.o(112267);
  }
  
  public FTSMainUIEducationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112268);
    this.BRc = new HashMap();
    this.BRd = new HashMap();
    this.BRe = "";
    this.pEE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.BRf = true;
    this.BRg = true;
    this.BRi = false;
    initView();
    AppMethodBeat.o(112268);
  }
  
  private void a(x.a parama)
  {
    AppMethodBeat.i(189587);
    LinearLayout localLinearLayout = (LinearLayout)inflate(getContext(), o.e.fts_main_ui_education_wxapp_layout, null);
    ((TextView)localLinearLayout.findViewById(o.d.title_tv)).setText(parama.wording);
    ImageView[] arrayOfImageView = new ImageView[4];
    arrayOfImageView[0] = ((ImageView)localLinearLayout.findViewById(o.d.app1_iv));
    arrayOfImageView[1] = ((ImageView)localLinearLayout.findViewById(o.d.app2_iv));
    arrayOfImageView[2] = ((ImageView)localLinearLayout.findViewById(o.d.app3_iv));
    arrayOfImageView[3] = ((ImageView)localLinearLayout.findViewById(o.d.app4_iv));
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(o.d.more_iv);
    int i = 0;
    while ((i < parama.lxh.size()) && (i < 4))
    {
      x.b localb = (x.b)parama.lxh.get(i);
      c.a locala = new c.a();
      locala.lRP = o.f.default_avatar;
      locala.kPz = true;
      q.bml().a(localb.nQm, arrayOfImageView[i], locala.bmL());
      arrayOfImageView[i].setVisibility(0);
      arrayOfImageView[i].setTag(localb);
      if (this.BRk != null) {
        arrayOfImageView[i].setOnClickListener(this.BRk);
      }
      i += 1;
    }
    if (parama.lxh.size() > 0)
    {
      localImageView.setVisibility(0);
      localImageView.setTag("more-click");
      localImageView.setOnClickListener(this.BRk);
    }
    addView(localLinearLayout);
    this.BRb.add(localLinearLayout);
    AppMethodBeat.o(189587);
  }
  
  private void a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, String paramString3, Object paramObject3, int paramInt)
  {
    AppMethodBeat.i(112275);
    Log.i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
    if (!Util.isNullOrNil(paramString1))
    {
      LinearLayout localLinearLayout = (LinearLayout)inflate(getContext(), o.e.fts_main_ui_education_cell_layout, null);
      View localView1 = localLinearLayout.findViewById(o.d.cell_1);
      TextView localTextView = (TextView)localLinearLayout.findViewById(o.d.textview_1);
      localTextView.setText(paramString1);
      localView1.setTag(paramObject1);
      localView1.setTag(o.d.tv_content, localTextView);
      localView1.setTag(o.d.is_cell_layout, Boolean.TRUE);
      View localView2 = localLinearLayout.findViewById(o.d.red_dot_1);
      localView1.setTag(o.d.red_dot, localView2);
      f(paramObject1, localView2);
      localView1.setVisibility(0);
      localTextView.setVisibility(0);
      localView1.setOnClickListener(this.BOf);
      localView1.setClickable(this.BRf);
      this.BRd.put(Integer.valueOf(n.a((JSONObject)paramObject1, paramString1, getContext())), localTextView);
      du(paramObject1);
      if (!Util.isNullOrNil(paramString2))
      {
        paramObject1 = localLinearLayout.findViewById(o.d.cell_2);
        paramString1 = (TextView)localLinearLayout.findViewById(o.d.textview_2);
        paramString1.setText(paramString2);
        paramString1.setVisibility(0);
        paramObject1.setTag(paramObject2);
        paramObject1.setTag(o.d.tv_content, paramString1);
        paramObject1.setTag(o.d.is_cell_layout, Boolean.TRUE);
        localView1 = localLinearLayout.findViewById(o.d.red_dot_2);
        paramObject1.setTag(o.d.red_dot, localView1);
        f(paramObject2, localView1);
        paramObject1.setVisibility(0);
        paramObject1.setOnClickListener(this.BOf);
        paramObject1.setClickable(this.BRf);
        paramObject1 = localLinearLayout.findViewById(o.d.divider_1);
        paramObject1.getLayoutParams().height = paramInt;
        paramObject1.setVisibility(0);
        this.BRd.put(Integer.valueOf(n.a((JSONObject)paramObject2, paramString2, getContext())), paramString1);
        du(paramObject2);
        if (!Util.isNullOrNil(paramString3))
        {
          paramObject1 = localLinearLayout.findViewById(o.d.cell_3);
          paramString1 = (TextView)localLinearLayout.findViewById(o.d.textview_3);
          paramString1.setText(paramString3);
          paramString1.setVisibility(0);
          paramObject1.setTag(paramObject3);
          paramObject1.setTag(o.d.tv_content, paramString1);
          paramObject1.setTag(o.d.is_cell_layout, Boolean.TRUE);
          paramString2 = localLinearLayout.findViewById(o.d.red_dot_3);
          paramObject1.setTag(o.d.red_dot, paramString2);
          f(paramObject3, paramString2);
          paramObject1.setVisibility(0);
          paramObject1.setOnClickListener(this.BOf);
          paramObject1.setClickable(this.BRf);
          paramObject1 = localLinearLayout.findViewById(o.d.divider_2);
          paramObject1.getLayoutParams().height = paramInt;
          paramObject1.setVisibility(0);
          this.BRd.put(Integer.valueOf(n.a((JSONObject)paramObject3, paramString3, getContext())), paramString1);
          du(paramObject3);
        }
      }
      this.BRb.add(localLinearLayout);
      addView(localLinearLayout);
    }
    AppMethodBeat.o(112275);
  }
  
  private void du(Object paramObject)
  {
    AppMethodBeat.i(112276);
    String str;
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      str = ((JSONObject)paramObject).optString("businessType");
      if (!Util.isNullOrNil(str)) {
        if (this.BRe != null) {
          break label119;
        }
      }
    }
    label119:
    for (paramObject = "";; paramObject = this.BRe)
    {
      this.BRe = paramObject;
      if (this.BRe.length() > 0) {
        this.BRe += "|";
      }
      this.BRe += str;
      AppMethodBeat.o(112276);
      return;
    }
  }
  
  private void esj()
  {
    AppMethodBeat.i(112274);
    a(getContext().getString(o.g.search_education_timeline), null, getContext().getString(o.g.search_education_article), null, getContext().getString(o.g.search_education_biz_contact), null, com.tencent.mm.ci.a.aY(getContext(), o.b.NormalTextSize));
    AppMethodBeat.o(112274);
  }
  
  private static void f(Object paramObject, View paramView)
  {
    AppMethodBeat.i(189564);
    if (((paramObject instanceof JSONObject)) && (paramView != null))
    {
      int i = ((JSONObject)paramObject).optInt("businessType");
      paramObject = l.BQo;
      if (l.NH(i))
      {
        paramView.setVisibility(0);
        paramObject = l.BQo;
        l.NI(i);
        AppMethodBeat.o(189564);
        return;
      }
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(189564);
  }
  
  private void initView()
  {
    AppMethodBeat.i(112269);
    setOrientation(1);
    this.BRb = new ArrayList();
    AppMethodBeat.o(112269);
  }
  
  public final void a(String paramString, WeakReference<View> paramWeakReference)
  {
    AppMethodBeat.i(189556);
    this.BRc.put(paramString, paramWeakReference);
    AppMethodBeat.o(189556);
  }
  
  public final void aIn(String paramString)
  {
    AppMethodBeat.i(189568);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(189568);
      return;
    }
    if (this.BRc.get(paramString) != null)
    {
      if ((((WeakReference)this.BRc.get(paramString)).get() instanceof View)) {
        ((View)((WeakReference)this.BRc.get(paramString)).get()).setVisibility(8);
      }
      this.BRc.remove(paramString);
    }
    AppMethodBeat.o(189568);
  }
  
  public String getVertBizTypes()
  {
    if (this.BRe == null) {
      return "";
    }
    return this.BRe;
  }
  
  public void setCellClickable(boolean paramBoolean)
  {
    this.BRf = paramBoolean;
  }
  
  public void setNeedHotWord(boolean paramBoolean)
  {
    this.BRg = paramBoolean;
  }
  
  public void setNeedWXAPP(boolean paramBoolean)
  {
    this.BRh = paramBoolean;
  }
  
  public void setOnCellClickListener(View.OnClickListener paramOnClickListener)
  {
    this.BOf = paramOnClickListener;
  }
  
  public void setOnHotwordClickListener(View.OnClickListener paramOnClickListener)
  {
    this.BRj = paramOnClickListener;
  }
  
  public void setOnWxAppClickListener(View.OnClickListener paramOnClickListener)
  {
    this.BRk = paramOnClickListener;
  }
  
  public void setSelected(int paramInt)
  {
    AppMethodBeat.i(112277);
    Iterator localIterator = this.BRd.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getKey()).intValue() == paramInt) {
        ((TextView)localEntry.getValue()).setTextColor(Color.parseColor("#B5B5B5"));
      } else {
        ((TextView)localEntry.getValue()).setTextColor(getContext().getResources().getColor(o.a.wechat_green));
      }
    }
    AppMethodBeat.o(112277);
  }
  
  /* Error */
  public final void updateView()
  {
    // Byte code:
    //   0: ldc_w 497
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 199	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRb	Ljava/util/List;
    //   10: invokeinterface 498 1 0
    //   15: astore_3
    //   16: aload_3
    //   17: invokeinterface 454 1 0
    //   22: ifeq +19 -> 41
    //   25: aload_0
    //   26: aload_3
    //   27: invokeinterface 457 1 0
    //   32: checkcast 4	android/widget/LinearLayout
    //   35: invokevirtual 501	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:removeView	(Landroid/view/View;)V
    //   38: goto -22 -> 16
    //   41: aload_0
    //   42: getfield 199	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRb	Ljava/util/List;
    //   45: invokeinterface 504 1 0
    //   50: aload_0
    //   51: getfield 46	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRd	Ljava/util/Map;
    //   54: invokeinterface 505 1 0
    //   59: aload_0
    //   60: ldc 48
    //   62: putfield 50	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRe	Ljava/lang/String;
    //   65: ldc_w 507
    //   68: invokestatic 513	com/tencent/mm/plugin/websearch/api/ak:biP	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   71: astore_3
    //   72: aload_3
    //   73: ifnonnull +233 -> 306
    //   76: iconst_0
    //   77: istore_1
    //   78: iload_1
    //   79: ifne +7 -> 86
    //   82: aload_0
    //   83: invokespecial 515	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:esj	()V
    //   86: aload_0
    //   87: getfield 70	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRg	Z
    //   90: ifeq +97 -> 187
    //   93: ldc_w 517
    //   96: invokestatic 513	com/tencent/mm/plugin/websearch/api/ak:biP	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   99: ldc_w 519
    //   102: invokevirtual 523	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   105: iconst_0
    //   106: invokevirtual 529	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   109: ldc_w 531
    //   112: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: invokestatic 222	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   120: ifne +67 -> 187
    //   123: aload_0
    //   124: invokevirtual 54	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:getContext	()Landroid/content/Context;
    //   127: getstatic 534	com/tencent/mm/plugin/fts/ui/o$e:fts_main_ui_education_hotword_layout	I
    //   130: aconst_null
    //   131: invokestatic 96	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   134: checkcast 4	android/widget/LinearLayout
    //   137: astore 4
    //   139: aload 4
    //   141: getstatic 537	com/tencent/mm/plugin/fts/ui/o$d:hotword_tv	I
    //   144: invokevirtual 105	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   147: checkcast 107	android/widget/TextView
    //   150: aload_3
    //   151: invokevirtual 116	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   154: aload 4
    //   156: aload_0
    //   157: getfield 435	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRj	Landroid/view/View$OnClickListener;
    //   160: invokevirtual 538	android/widget/LinearLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   163: aload 4
    //   165: aload_3
    //   166: invokevirtual 539	android/widget/LinearLayout:setTag	(Ljava/lang/Object;)V
    //   169: aload_0
    //   170: aload 4
    //   172: invokevirtual 197	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:addView	(Landroid/view/View;)V
    //   175: aload_0
    //   176: getfield 199	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRb	Ljava/util/List;
    //   179: aload 4
    //   181: invokeinterface 203 2 0
    //   186: pop
    //   187: aload_0
    //   188: getfield 431	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRh	Z
    //   191: ifeq +514 -> 705
    //   194: ldc_w 541
    //   197: invokestatic 547	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   200: checkcast 541	com/tencent/mm/plugin/appbrand/service/x
    //   203: invokeinterface 551 1 0
    //   208: astore 4
    //   210: aload 4
    //   212: getfield 136	com/tencent/mm/plugin/appbrand/service/x$a:lxh	Ljava/util/List;
    //   215: ifnull +490 -> 705
    //   218: aload 4
    //   220: getfield 136	com/tencent/mm/plugin/appbrand/service/x$a:lxh	Ljava/util/List;
    //   223: invokeinterface 141 1 0
    //   228: ifle +477 -> 705
    //   231: aload_0
    //   232: aload 4
    //   234: invokespecial 553	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:a	(Lcom/tencent/mm/plugin/appbrand/service/x$a;)V
    //   237: aload 4
    //   239: getfield 136	com/tencent/mm/plugin/appbrand/service/x$a:lxh	Ljava/util/List;
    //   242: invokeinterface 498 1 0
    //   247: astore 5
    //   249: ldc 48
    //   251: astore_3
    //   252: aload 5
    //   254: invokeinterface 454 1 0
    //   259: ifeq +388 -> 647
    //   262: aload 5
    //   264: invokeinterface 457 1 0
    //   269: checkcast 146	com/tencent/mm/plugin/appbrand/service/x$b
    //   272: astore 6
    //   274: new 337	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   281: aload_3
    //   282: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 6
    //   287: getfield 556	com/tencent/mm/plugin/appbrand/service/x$b:username	Ljava/lang/String;
    //   290: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 558
    //   296: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: astore_3
    //   303: goto -51 -> 252
    //   306: aload_3
    //   307: ldc_w 560
    //   310: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   313: pop
    //   314: aload_3
    //   315: ldc_w 519
    //   318: invokevirtual 523	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   321: astore 8
    //   323: aload 8
    //   325: ifnonnull +8 -> 333
    //   328: iconst_0
    //   329: istore_1
    //   330: goto -252 -> 78
    //   333: invokestatic 563	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   336: invokestatic 569	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentLanguage	(Landroid/content/Context;)Ljava/lang/String;
    //   339: ldc_w 571
    //   342: invokevirtual 574	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   345: ifeq +61 -> 406
    //   348: aload_0
    //   349: invokevirtual 54	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:getContext	()Landroid/content/Context;
    //   352: getstatic 577	com/tencent/mm/plugin/fts/ui/o$b:BiggerMoreTextSize	I
    //   355: invokestatic 378	com/tencent/mm/ci/a:aY	(Landroid/content/Context;I)I
    //   358: istore_1
    //   359: goto +357 -> 716
    //   362: iload_2
    //   363: aload 8
    //   365: invokevirtual 578	org/json/JSONArray:length	()I
    //   368: bipush 9
    //   370: invokestatic 584	java/lang/Math:min	(II)I
    //   373: if_icmpge +107 -> 480
    //   376: aload 8
    //   378: iload_2
    //   379: invokevirtual 529	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   382: astore 7
    //   384: iload_2
    //   385: iconst_3
    //   386: irem
    //   387: ifne +33 -> 420
    //   390: aload 7
    //   392: ldc_w 531
    //   395: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore_3
    //   399: aload 7
    //   401: astore 4
    //   403: goto +329 -> 732
    //   406: aload_0
    //   407: invokevirtual 54	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:getContext	()Landroid/content/Context;
    //   410: getstatic 372	com/tencent/mm/plugin/fts/ui/o$b:NormalTextSize	I
    //   413: invokestatic 378	com/tencent/mm/ci/a:aY	(Landroid/content/Context;I)I
    //   416: istore_1
    //   417: goto +299 -> 716
    //   420: iload_2
    //   421: iconst_3
    //   422: irem
    //   423: iconst_1
    //   424: if_icmpne +20 -> 444
    //   427: aload 7
    //   429: ldc_w 531
    //   432: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   435: astore 5
    //   437: aload 7
    //   439: astore 6
    //   441: goto +291 -> 732
    //   444: aload_0
    //   445: aload_3
    //   446: aload 4
    //   448: aload 5
    //   450: aload 6
    //   452: aload 7
    //   454: ldc_w 531
    //   457: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   460: aload 7
    //   462: iload_1
    //   463: invokespecial 380	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;I)V
    //   466: aconst_null
    //   467: astore 6
    //   469: aconst_null
    //   470: astore 4
    //   472: aconst_null
    //   473: astore 5
    //   475: aconst_null
    //   476: astore_3
    //   477: goto +255 -> 732
    //   480: aload_3
    //   481: ifnull +22 -> 503
    //   484: aload 4
    //   486: ifnull +17 -> 503
    //   489: aload_0
    //   490: aload_3
    //   491: aload 4
    //   493: aload 5
    //   495: aload 6
    //   497: aconst_null
    //   498: aconst_null
    //   499: iload_1
    //   500: invokespecial 380	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;I)V
    //   503: aload_0
    //   504: getfield 72	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRi	Z
    //   507: ifne +127 -> 634
    //   510: aload_0
    //   511: iconst_1
    //   512: putfield 72	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:BRi	Z
    //   515: aload 8
    //   517: ifnull +117 -> 634
    //   520: new 337	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   527: astore 4
    //   529: iconst_0
    //   530: istore_1
    //   531: iload_1
    //   532: aload 8
    //   534: invokevirtual 578	org/json/JSONArray:length	()I
    //   537: if_icmpge +86 -> 623
    //   540: aload 8
    //   542: iload_1
    //   543: invokevirtual 529	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   546: astore_3
    //   547: aload_3
    //   548: ifnull +191 -> 739
    //   551: aload_3
    //   552: ldc_w 326
    //   555: invokevirtual 385	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   558: istore_2
    //   559: ldc 48
    //   561: astore_3
    //   562: getstatic 391	com/tencent/mm/plugin/fts/ui/b/l:BQo	Lcom/tencent/mm/plugin/fts/ui/b/l;
    //   565: astore 5
    //   567: iload_2
    //   568: i2l
    //   569: invokestatic 395	com/tencent/mm/plugin/fts/ui/b/l:NH	(J)Z
    //   572: ifeq +11 -> 583
    //   575: getstatic 391	com/tencent/mm/plugin/fts/ui/b/l:BQo	Lcom/tencent/mm/plugin/fts/ui/b/l;
    //   578: astore_3
    //   579: invokestatic 587	com/tencent/mm/plugin/fts/ui/b/l:erY	()Ljava/lang/String;
    //   582: astore_3
    //   583: aload 4
    //   585: invokevirtual 588	java/lang/StringBuilder:length	()I
    //   588: ifle +12 -> 600
    //   591: aload 4
    //   593: ldc_w 558
    //   596: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 4
    //   602: iload_2
    //   603: invokevirtual 591	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload 4
    //   609: ldc_w 593
    //   612: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_3
    //   616: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: goto +119 -> 739
    //   623: invokestatic 598	com/tencent/mm/plugin/fts/a/e:eqP	()Ljava/lang/String;
    //   626: aload 4
    //   628: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 604	com/tencent/mm/plugin/websearch/api/ar:mj	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: iconst_1
    //   635: istore_1
    //   636: goto -558 -> 78
    //   639: astore_3
    //   640: aload_0
    //   641: invokespecial 515	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:esj	()V
    //   644: goto -558 -> 86
    //   647: getstatic 610	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   650: sipush 14630
    //   653: iconst_5
    //   654: anewarray 211	java/lang/Object
    //   657: dup
    //   658: iconst_0
    //   659: getstatic 614	com/tencent/mm/plugin/fts/a/e:BHi	J
    //   662: invokestatic 619	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   665: aastore
    //   666: dup
    //   667: iconst_1
    //   668: aload 4
    //   670: getfield 112	com/tencent/mm/plugin/appbrand/service/x$a:wording	Ljava/lang/String;
    //   673: aastore
    //   674: dup
    //   675: iconst_2
    //   676: aload_3
    //   677: aastore
    //   678: dup
    //   679: iconst_3
    //   680: aload 4
    //   682: getfield 622	com/tencent/mm/plugin/appbrand/service/x$a:qOL	I
    //   685: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   688: aastore
    //   689: dup
    //   690: iconst_4
    //   691: invokestatic 628	java/lang/System:currentTimeMillis	()J
    //   694: ldc2_w 629
    //   697: ldiv
    //   698: invokestatic 619	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   701: aastore
    //   702: invokevirtual 633	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   705: ldc_w 497
    //   708: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   711: return
    //   712: astore_3
    //   713: goto -526 -> 187
    //   716: iconst_0
    //   717: istore_2
    //   718: aconst_null
    //   719: astore 6
    //   721: aconst_null
    //   722: astore 4
    //   724: aconst_null
    //   725: astore 5
    //   727: aconst_null
    //   728: astore_3
    //   729: goto -367 -> 362
    //   732: iload_2
    //   733: iconst_1
    //   734: iadd
    //   735: istore_2
    //   736: goto -374 -> 362
    //   739: iload_1
    //   740: iconst_1
    //   741: iadd
    //   742: istore_1
    //   743: goto -212 -> 531
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	746	0	this	FTSMainUIEducationLayout
    //   77	666	1	i	int
    //   362	374	2	j	int
    //   15	601	3	localObject1	Object
    //   639	38	3	localException1	java.lang.Exception
    //   712	1	3	localException2	java.lang.Exception
    //   728	1	3	localObject2	Object
    //   137	586	4	localObject3	Object
    //   247	479	5	localObject4	Object
    //   272	448	6	localObject5	Object
    //   382	79	7	localJSONObject	JSONObject
    //   321	220	8	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   65	72	639	java/lang/Exception
    //   82	86	639	java/lang/Exception
    //   306	323	639	java/lang/Exception
    //   333	359	639	java/lang/Exception
    //   362	384	639	java/lang/Exception
    //   390	399	639	java/lang/Exception
    //   406	417	639	java/lang/Exception
    //   427	437	639	java/lang/Exception
    //   444	466	639	java/lang/Exception
    //   489	503	639	java/lang/Exception
    //   503	515	639	java/lang/Exception
    //   520	529	639	java/lang/Exception
    //   531	547	639	java/lang/Exception
    //   551	559	639	java/lang/Exception
    //   562	567	639	java/lang/Exception
    //   567	583	639	java/lang/Exception
    //   583	600	639	java/lang/Exception
    //   600	620	639	java/lang/Exception
    //   623	634	639	java/lang/Exception
    //   86	187	712	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout
 * JD-Core Version:    0.7.0.1
 */