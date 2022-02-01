package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private float mFs;
  protected View.OnClickListener xcf;
  protected List<LinearLayout> xeS;
  protected Map<Integer, TextView> xeT;
  private String xeU;
  private boolean xeV;
  protected boolean xeW;
  private boolean xeX;
  public View.OnClickListener xeY;
  private View.OnClickListener xeZ;
  
  public FTSMainUIEducationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112267);
    this.xeT = new HashMap();
    this.xeU = "";
    this.mFs = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.xeV = true;
    this.xeW = true;
    initView();
    AppMethodBeat.o(112267);
  }
  
  public FTSMainUIEducationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112268);
    this.xeT = new HashMap();
    this.xeU = "";
    this.mFs = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.xeV = true;
    this.xeW = true;
    initView();
    AppMethodBeat.o(112268);
  }
  
  private void a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, String paramString3, Object paramObject3, int paramInt)
  {
    AppMethodBeat.i(112275);
    Log.i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
    if (!Util.isNullOrNil(paramString1))
    {
      LinearLayout localLinearLayout = (LinearLayout)inflate(getContext(), 2131494765, null);
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131309026);
      localTextView.setText(paramString1);
      localTextView.setTag(paramObject1);
      localTextView.setVisibility(0);
      localTextView.setOnClickListener(this.xcf);
      localTextView.setClickable(this.xeV);
      this.xeT.put(Integer.valueOf(n.a((JSONObject)paramObject1, paramString1, getContext())), localTextView);
      dq(paramObject1);
      if (!Util.isNullOrNil(paramString2))
      {
        paramString1 = (TextView)localLinearLayout.findViewById(2131309027);
        paramString1.setText(paramString2);
        paramString1.setTag(paramObject2);
        paramString1.setVisibility(0);
        paramString1.setOnClickListener(this.xcf);
        paramString1.setClickable(this.xeV);
        paramObject1 = localLinearLayout.findViewById(2131299699);
        paramObject1.getLayoutParams().height = paramInt;
        paramObject1.setVisibility(0);
        this.xeT.put(Integer.valueOf(n.a((JSONObject)paramObject2, paramString2, getContext())), paramString1);
        dq(paramObject2);
        if (!Util.isNullOrNil(paramString3))
        {
          paramString1 = (TextView)localLinearLayout.findViewById(2131309028);
          paramString1.setText(paramString3);
          paramString1.setTag(paramObject3);
          paramString1.setVisibility(0);
          paramString1.setOnClickListener(this.xcf);
          paramString1.setClickable(this.xeV);
          paramObject1 = localLinearLayout.findViewById(2131299700);
          paramObject1.getLayoutParams().height = paramInt;
          paramObject1.setVisibility(0);
          this.xeT.put(Integer.valueOf(n.a((JSONObject)paramObject3, paramString3, getContext())), paramString1);
          dq(paramObject3);
        }
      }
      this.xeS.add(localLinearLayout);
      addView(localLinearLayout);
    }
    AppMethodBeat.o(112275);
  }
  
  private void dPK()
  {
    AppMethodBeat.i(112274);
    a(getContext().getString(2131765078), null, getContext().getString(2131765074), null, getContext().getString(2131765075), null, a.aG(getContext(), 2131165535));
    AppMethodBeat.o(112274);
  }
  
  private void dq(Object paramObject)
  {
    AppMethodBeat.i(112276);
    String str;
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      str = ((JSONObject)paramObject).optString("businessType");
      if (!Util.isNullOrNil(str)) {
        if (this.xeU != null) {
          break label115;
        }
      }
    }
    label115:
    for (paramObject = "";; paramObject = this.xeU)
    {
      this.xeU = paramObject;
      if (this.xeU.length() > 0) {
        this.xeU += "|";
      }
      this.xeU += str;
      AppMethodBeat.o(112276);
      return;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(112269);
    setOrientation(1);
    this.xeS = new ArrayList();
    AppMethodBeat.o(112269);
  }
  
  public String getVertBizTypes()
  {
    if (this.xeU == null) {
      return "";
    }
    return this.xeU;
  }
  
  public void setCellClickable(boolean paramBoolean)
  {
    this.xeV = paramBoolean;
  }
  
  public void setNeedHotWord(boolean paramBoolean)
  {
    this.xeW = paramBoolean;
  }
  
  public void setNeedWXAPP(boolean paramBoolean)
  {
    this.xeX = paramBoolean;
  }
  
  public void setOnCellClickListener(View.OnClickListener paramOnClickListener)
  {
    this.xcf = paramOnClickListener;
  }
  
  public void setOnHotwordClickListener(View.OnClickListener paramOnClickListener)
  {
    this.xeY = paramOnClickListener;
  }
  
  public void setOnWxAppClickListener(View.OnClickListener paramOnClickListener)
  {
    this.xeZ = paramOnClickListener;
  }
  
  public void setSelected(int paramInt)
  {
    AppMethodBeat.i(112277);
    Iterator localIterator = this.xeT.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getKey()).intValue() == paramInt) {
        ((TextView)localEntry.getValue()).setTextColor(Color.parseColor("#B5B5B5"));
      } else {
        ((TextView)localEntry.getValue()).setTextColor(getContext().getResources().getColor(2131101414));
      }
    }
    AppMethodBeat.o(112277);
  }
  
  /* Error */
  public final void updateView()
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 169	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeS	Ljava/util/List;
    //   10: invokeinterface 304 1 0
    //   15: astore_3
    //   16: aload_3
    //   17: invokeinterface 262 1 0
    //   22: ifeq +19 -> 41
    //   25: aload_0
    //   26: aload_3
    //   27: invokeinterface 266 1 0
    //   32: checkcast 4	android/widget/LinearLayout
    //   35: invokevirtual 307	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:removeView	(Landroid/view/View;)V
    //   38: goto -22 -> 16
    //   41: aload_0
    //   42: getfield 169	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeS	Ljava/util/List;
    //   45: invokeinterface 310 1 0
    //   50: aload_0
    //   51: getfield 40	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeT	Ljava/util/Map;
    //   54: invokeinterface 311 1 0
    //   59: aload_0
    //   60: ldc 42
    //   62: putfield 44	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeU	Ljava/lang/String;
    //   65: ldc_w 313
    //   68: invokestatic 319	com/tencent/mm/plugin/websearch/api/ak:aXe	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   71: astore_3
    //   72: aload_3
    //   73: ifnonnull +387 -> 460
    //   76: iconst_0
    //   77: istore_1
    //   78: iload_1
    //   79: ifne +7 -> 86
    //   82: aload_0
    //   83: invokespecial 321	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:dPK	()V
    //   86: aload_0
    //   87: getfield 64	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeW	Z
    //   90: ifeq +97 -> 187
    //   93: ldc_w 323
    //   96: invokestatic 319	com/tencent/mm/plugin/websearch/api/ak:aXe	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   99: ldc_w 325
    //   102: invokevirtual 329	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   105: iconst_0
    //   106: invokevirtual 335	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   109: ldc_w 337
    //   112: invokevirtual 206	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: invokestatic 95	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   120: ifne +67 -> 187
    //   123: aload_0
    //   124: invokevirtual 48	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:getContext	()Landroid/content/Context;
    //   127: ldc_w 338
    //   130: aconst_null
    //   131: invokestatic 100	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   134: checkcast 4	android/widget/LinearLayout
    //   137: astore 4
    //   139: aload 4
    //   141: ldc_w 339
    //   144: invokevirtual 105	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   147: checkcast 107	android/widget/TextView
    //   150: aload_3
    //   151: invokevirtual 111	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   154: aload 4
    //   156: aload_0
    //   157: getfield 241	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeY	Landroid/view/View$OnClickListener;
    //   160: invokevirtual 340	android/widget/LinearLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   163: aload 4
    //   165: aload_3
    //   166: invokevirtual 341	android/widget/LinearLayout:setTag	(Ljava/lang/Object;)V
    //   169: aload_0
    //   170: aload 4
    //   172: invokevirtual 179	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:addView	(Landroid/view/View;)V
    //   175: aload_0
    //   176: getfield 169	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeS	Ljava/util/List;
    //   179: aload 4
    //   181: invokeinterface 175 2 0
    //   186: pop
    //   187: aload_0
    //   188: getfield 237	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeX	Z
    //   191: ifeq +657 -> 848
    //   194: ldc_w 343
    //   197: invokestatic 349	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   200: checkcast 343	com/tencent/mm/plugin/appbrand/service/x
    //   203: invokeinterface 353 1 0
    //   208: astore 4
    //   210: aload 4
    //   212: getfield 358	com/tencent/mm/plugin/appbrand/service/x$a:iHf	Ljava/util/List;
    //   215: ifnull +633 -> 848
    //   218: aload 4
    //   220: getfield 358	com/tencent/mm/plugin/appbrand/service/x$a:iHf	Ljava/util/List;
    //   223: invokeinterface 361 1 0
    //   228: ifle +620 -> 848
    //   231: aload_0
    //   232: invokevirtual 48	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:getContext	()Landroid/content/Context;
    //   235: ldc_w 362
    //   238: aconst_null
    //   239: invokestatic 100	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   242: checkcast 4	android/widget/LinearLayout
    //   245: astore_3
    //   246: aload_3
    //   247: ldc_w 363
    //   250: invokevirtual 105	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   253: checkcast 107	android/widget/TextView
    //   256: aload 4
    //   258: getfield 366	com/tencent/mm/plugin/appbrand/service/x$a:dQx	Ljava/lang/String;
    //   261: invokevirtual 111	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   264: iconst_4
    //   265: anewarray 368	android/widget/ImageView
    //   268: astore 5
    //   270: aload 5
    //   272: iconst_0
    //   273: aload_3
    //   274: ldc_w 369
    //   277: invokevirtual 105	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   280: checkcast 368	android/widget/ImageView
    //   283: aastore
    //   284: aload 5
    //   286: iconst_1
    //   287: aload_3
    //   288: ldc_w 370
    //   291: invokevirtual 105	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   294: checkcast 368	android/widget/ImageView
    //   297: aastore
    //   298: aload 5
    //   300: iconst_2
    //   301: aload_3
    //   302: ldc_w 371
    //   305: invokevirtual 105	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   308: checkcast 368	android/widget/ImageView
    //   311: aastore
    //   312: aload 5
    //   314: iconst_3
    //   315: aload_3
    //   316: ldc_w 372
    //   319: invokevirtual 105	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   322: checkcast 368	android/widget/ImageView
    //   325: aastore
    //   326: aload_3
    //   327: ldc_w 373
    //   330: invokevirtual 105	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   333: checkcast 368	android/widget/ImageView
    //   336: astore 6
    //   338: iconst_0
    //   339: istore_1
    //   340: iload_1
    //   341: aload 4
    //   343: getfield 358	com/tencent/mm/plugin/appbrand/service/x$a:iHf	Ljava/util/List;
    //   346: invokeinterface 361 1 0
    //   351: if_icmpge +318 -> 669
    //   354: iload_1
    //   355: iconst_4
    //   356: if_icmpge +313 -> 669
    //   359: aload 4
    //   361: getfield 358	com/tencent/mm/plugin/appbrand/service/x$a:iHf	Ljava/util/List;
    //   364: iload_1
    //   365: invokeinterface 376 2 0
    //   370: checkcast 378	com/tencent/mm/plugin/appbrand/service/x$b
    //   373: astore 7
    //   375: new 380	com/tencent/mm/av/a/a/c$a
    //   378: dup
    //   379: invokespecial 381	com/tencent/mm/av/a/a/c$a:<init>	()V
    //   382: astore 8
    //   384: aload 8
    //   386: ldc_w 382
    //   389: putfield 385	com/tencent/mm/av/a/a/c$a:jbq	I
    //   392: aload 8
    //   394: iconst_1
    //   395: putfield 388	com/tencent/mm/av/a/a/c$a:iaT	Z
    //   398: invokestatic 394	com/tencent/mm/av/q:bcV	()Lcom/tencent/mm/av/a/a;
    //   401: aload 7
    //   403: getfield 397	com/tencent/mm/plugin/appbrand/service/x$b:kVZ	Ljava/lang/String;
    //   406: aload 5
    //   408: iload_1
    //   409: aaload
    //   410: aload 8
    //   412: invokevirtual 401	com/tencent/mm/av/a/a/c$a:bdv	()Lcom/tencent/mm/av/a/a/c;
    //   415: invokevirtual 406	com/tencent/mm/av/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/av/a/a/c;)V
    //   418: aload 5
    //   420: iload_1
    //   421: aaload
    //   422: iconst_0
    //   423: invokevirtual 407	android/widget/ImageView:setVisibility	(I)V
    //   426: aload 5
    //   428: iload_1
    //   429: aaload
    //   430: aload 7
    //   432: invokevirtual 408	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   435: aload_0
    //   436: getfield 244	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeZ	Landroid/view/View$OnClickListener;
    //   439: ifnull +14 -> 453
    //   442: aload 5
    //   444: iload_1
    //   445: aaload
    //   446: aload_0
    //   447: getfield 244	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeZ	Landroid/view/View$OnClickListener;
    //   450: invokevirtual 409	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   453: iload_1
    //   454: iconst_1
    //   455: iadd
    //   456: istore_1
    //   457: goto -117 -> 340
    //   460: aload_3
    //   461: ldc_w 411
    //   464: invokevirtual 206	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: pop
    //   468: aload_3
    //   469: ldc_w 325
    //   472: invokevirtual 329	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   475: astore 8
    //   477: aload 8
    //   479: ifnonnull +8 -> 487
    //   482: iconst_0
    //   483: istore_1
    //   484: goto -406 -> 78
    //   487: invokestatic 414	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   490: invokestatic 420	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentLanguage	(Landroid/content/Context;)Ljava/lang/String;
    //   493: ldc_w 422
    //   496: invokevirtual 425	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   499: ifeq +61 -> 560
    //   502: aload_0
    //   503: invokevirtual 48	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:getContext	()Landroid/content/Context;
    //   506: ldc_w 426
    //   509: invokestatic 197	com/tencent/mm/cb/a:aG	(Landroid/content/Context;I)I
    //   512: istore_1
    //   513: goto +346 -> 859
    //   516: iload_2
    //   517: aload 8
    //   519: invokevirtual 427	org/json/JSONArray:length	()I
    //   522: bipush 9
    //   524: invokestatic 433	java/lang/Math:min	(II)I
    //   527: if_icmpge +106 -> 633
    //   530: aload 8
    //   532: iload_2
    //   533: invokevirtual 335	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   536: astore 7
    //   538: iload_2
    //   539: iconst_3
    //   540: irem
    //   541: ifne +32 -> 573
    //   544: aload 7
    //   546: ldc_w 337
    //   549: invokevirtual 206	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   552: astore_3
    //   553: aload 7
    //   555: astore 4
    //   557: goto +318 -> 875
    //   560: aload_0
    //   561: invokevirtual 48	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:getContext	()Landroid/content/Context;
    //   564: ldc 191
    //   566: invokestatic 197	com/tencent/mm/cb/a:aG	(Landroid/content/Context;I)I
    //   569: istore_1
    //   570: goto +289 -> 859
    //   573: iload_2
    //   574: iconst_3
    //   575: irem
    //   576: iconst_1
    //   577: if_icmpne +20 -> 597
    //   580: aload 7
    //   582: ldc_w 337
    //   585: invokevirtual 206	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   588: astore 5
    //   590: aload 7
    //   592: astore 6
    //   594: goto +281 -> 875
    //   597: aload_0
    //   598: aload_3
    //   599: aload 4
    //   601: aload 5
    //   603: aload 6
    //   605: aload 7
    //   607: ldc_w 337
    //   610: invokevirtual 206	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   613: aload 7
    //   615: iload_1
    //   616: invokespecial 199	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;I)V
    //   619: aconst_null
    //   620: astore 4
    //   622: aconst_null
    //   623: astore 5
    //   625: aconst_null
    //   626: astore_3
    //   627: aconst_null
    //   628: astore 6
    //   630: goto +245 -> 875
    //   633: aload_3
    //   634: ifnull +22 -> 656
    //   637: aload 4
    //   639: ifnull +17 -> 656
    //   642: aload_0
    //   643: aload_3
    //   644: aload 4
    //   646: aload 5
    //   648: aload 6
    //   650: aconst_null
    //   651: aconst_null
    //   652: iload_1
    //   653: invokespecial 199	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;I)V
    //   656: iconst_1
    //   657: istore_1
    //   658: goto -580 -> 78
    //   661: astore_3
    //   662: aload_0
    //   663: invokespecial 321	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:dPK	()V
    //   666: goto -580 -> 86
    //   669: aload 4
    //   671: getfield 358	com/tencent/mm/plugin/appbrand/service/x$a:iHf	Ljava/util/List;
    //   674: invokeinterface 361 1 0
    //   679: ifle +26 -> 705
    //   682: aload 6
    //   684: iconst_0
    //   685: invokevirtual 407	android/widget/ImageView:setVisibility	(I)V
    //   688: aload 6
    //   690: ldc_w 435
    //   693: invokevirtual 408	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   696: aload 6
    //   698: aload_0
    //   699: getfield 244	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeZ	Landroid/view/View$OnClickListener;
    //   702: invokevirtual 409	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   705: aload_0
    //   706: aload_3
    //   707: invokevirtual 179	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:addView	(Landroid/view/View;)V
    //   710: aload_0
    //   711: getfield 169	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:xeS	Ljava/util/List;
    //   714: aload_3
    //   715: invokeinterface 175 2 0
    //   720: pop
    //   721: aload 4
    //   723: getfield 358	com/tencent/mm/plugin/appbrand/service/x$a:iHf	Ljava/util/List;
    //   726: invokeinterface 304 1 0
    //   731: astore 5
    //   733: ldc 42
    //   735: astore_3
    //   736: aload 5
    //   738: invokeinterface 262 1 0
    //   743: ifeq +47 -> 790
    //   746: aload 5
    //   748: invokeinterface 266 1 0
    //   753: checkcast 378	com/tencent/mm/plugin/appbrand/service/x$b
    //   756: astore 6
    //   758: new 213	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   765: aload_3
    //   766: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload 6
    //   771: getfield 438	com/tencent/mm/plugin/appbrand/service/x$b:username	Ljava/lang/String;
    //   774: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: ldc_w 440
    //   780: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: astore_3
    //   787: goto -51 -> 736
    //   790: getstatic 446	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   793: sipush 14630
    //   796: iconst_5
    //   797: anewarray 84	java/lang/Object
    //   800: dup
    //   801: iconst_0
    //   802: getstatic 452	com/tencent/mm/plugin/fts/a/e:wVm	J
    //   805: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   808: aastore
    //   809: dup
    //   810: iconst_1
    //   811: aload 4
    //   813: getfield 366	com/tencent/mm/plugin/appbrand/service/x$a:dQx	Ljava/lang/String;
    //   816: aastore
    //   817: dup
    //   818: iconst_2
    //   819: aload_3
    //   820: aastore
    //   821: dup
    //   822: iconst_3
    //   823: aload 4
    //   825: getfield 460	com/tencent/mm/plugin/appbrand/service/x$a:nMt	I
    //   828: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   831: aastore
    //   832: dup
    //   833: iconst_4
    //   834: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   837: ldc2_w 467
    //   840: ldiv
    //   841: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   844: aastore
    //   845: invokevirtual 471	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   848: ldc_w 303
    //   851: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   854: return
    //   855: astore_3
    //   856: goto -669 -> 187
    //   859: aconst_null
    //   860: astore 4
    //   862: aconst_null
    //   863: astore 5
    //   865: aconst_null
    //   866: astore_3
    //   867: aconst_null
    //   868: astore 6
    //   870: iconst_0
    //   871: istore_2
    //   872: goto -356 -> 516
    //   875: iload_2
    //   876: iconst_1
    //   877: iadd
    //   878: istore_2
    //   879: goto -363 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	882	0	this	FTSMainUIEducationLayout
    //   77	581	1	i	int
    //   516	363	2	j	int
    //   15	629	3	localObject1	Object
    //   661	54	3	localException1	java.lang.Exception
    //   735	85	3	str	String
    //   855	1	3	localException2	java.lang.Exception
    //   866	1	3	localObject2	Object
    //   137	724	4	localObject3	Object
    //   268	596	5	localObject4	Object
    //   336	533	6	localObject5	Object
    //   373	241	7	localObject6	Object
    //   382	149	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   65	72	661	java/lang/Exception
    //   82	86	661	java/lang/Exception
    //   460	477	661	java/lang/Exception
    //   487	513	661	java/lang/Exception
    //   516	538	661	java/lang/Exception
    //   544	553	661	java/lang/Exception
    //   560	570	661	java/lang/Exception
    //   580	590	661	java/lang/Exception
    //   597	619	661	java/lang/Exception
    //   642	656	661	java/lang/Exception
    //   86	187	855	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout
 * JD-Core Version:    0.7.0.1
 */