package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayout
  extends LinearLayout
{
  private float bTE;
  private float bTF;
  private float ifc;
  protected View.OnClickListener mYg;
  protected List<LinearLayout> nbh;
  protected Map<Integer, TextView> nbi;
  private String nbj;
  private long nbk;
  private boolean nbl;
  private TextView nbm;
  protected boolean nbn;
  private boolean nbo;
  public View.OnClickListener nbp;
  private View.OnClickListener nbq;
  
  public FTSMainUIEducationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62144);
    this.nbi = new HashMap();
    this.nbj = "";
    this.ifc = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.nbl = true;
    this.nbn = true;
    initView();
    AppMethodBeat.o(62144);
  }
  
  public FTSMainUIEducationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62145);
    this.nbi = new HashMap();
    this.nbj = "";
    this.ifc = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.nbl = true;
    this.nbn = true;
    initView();
    AppMethodBeat.o(62145);
  }
  
  private void bDl()
  {
    AppMethodBeat.i(62149);
    Iterator localIterator = this.nbh.iterator();
    while (localIterator.hasNext()) {
      removeView((LinearLayout)localIterator.next());
    }
    this.nbh.clear();
    this.nbi.clear();
    this.nbj = "";
    AppMethodBeat.o(62149);
  }
  
  private void bDm()
  {
    AppMethodBeat.i(62151);
    a(getContext().getString(2131303003), null, getContext().getString(2131302999), null, getContext().getString(2131303000), null, a.ao(getContext(), 2131427809));
    bDn();
    AppMethodBeat.o(62151);
  }
  
  private void bN(Object paramObject)
  {
    AppMethodBeat.i(62153);
    String str;
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      str = ((JSONObject)paramObject).optString("businessType");
      if (!bo.isNullOrNil(str)) {
        if (this.nbj != null) {
          break label115;
        }
      }
    }
    label115:
    for (paramObject = "";; paramObject = this.nbj)
    {
      this.nbj = paramObject;
      if (this.nbj.length() > 0) {
        this.nbj += "|";
      }
      this.nbj += str;
      AppMethodBeat.o(62153);
      return;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(62146);
    setOrientation(1);
    this.nbh = new ArrayList();
    AppMethodBeat.o(62146);
  }
  
  public final void L(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(62156);
    ab.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62156);
      return;
      Iterator localIterator = this.nbi.values().iterator();
      TextView localTextView;
      int[] arrayOfInt;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localTextView = (TextView)localIterator.next();
        arrayOfInt = new int[2];
        localTextView.getLocationOnScreen(arrayOfInt);
      } while (!new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + localTextView.getWidth(), arrayOfInt[1] + localTextView.getHeight()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
      while (localTextView != null)
      {
        this.nbm = localTextView;
        this.bTE = paramMotionEvent.getRawX();
        this.bTF = paramMotionEvent.getRawY();
        this.nbk = System.currentTimeMillis();
        AppMethodBeat.o(62156);
        return;
        localTextView = null;
      }
      if (this.nbm != null)
      {
        float f1 = paramMotionEvent.getRawX() - this.bTE;
        float f2 = paramMotionEvent.getRawY() - this.bTF;
        ab.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action up deltaX %f, deltaY %f, time interval %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Long.valueOf(System.currentTimeMillis() - this.nbk) });
        if ((Math.abs(f1) <= this.ifc) && (Math.abs(f2) <= this.ifc) && (System.currentTimeMillis() - this.nbk < 200L) && (this.mYg != null)) {
          this.mYg.onClick(this.nbm);
        }
        this.nbm = null;
        AppMethodBeat.o(62156);
        return;
        this.nbm = null;
      }
    }
  }
  
  protected final void a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, String paramString3, Object paramObject3, int paramInt)
  {
    AppMethodBeat.i(62152);
    ab.i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
    if (!bo.isNullOrNil(paramString1))
    {
      LinearLayout localLinearLayout = (LinearLayout)inflate(getContext(), 2130969667, null);
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131824371);
      localTextView.setText(paramString1);
      localTextView.setTag(paramObject1);
      localTextView.setVisibility(0);
      localTextView.setOnClickListener(this.mYg);
      localTextView.setClickable(this.nbl);
      this.nbi.put(Integer.valueOf(m.a((JSONObject)paramObject1, paramString1, getContext())), localTextView);
      bN(paramObject1);
      if (!bo.isNullOrNil(paramString2))
      {
        paramString1 = (TextView)localLinearLayout.findViewById(2131824373);
        paramString1.setText(paramString2);
        paramString1.setTag(paramObject2);
        paramString1.setVisibility(0);
        paramString1.setOnClickListener(this.mYg);
        paramString1.setClickable(this.nbl);
        paramObject1 = localLinearLayout.findViewById(2131824372);
        paramObject1.getLayoutParams().height = paramInt;
        paramObject1.setVisibility(0);
        this.nbi.put(Integer.valueOf(m.a((JSONObject)paramObject2, paramString2, getContext())), paramString1);
        bN(paramObject2);
        if (!bo.isNullOrNil(paramString3))
        {
          paramString1 = (TextView)localLinearLayout.findViewById(2131824375);
          paramString1.setText(paramString3);
          paramString1.setTag(paramObject3);
          paramString1.setVisibility(0);
          paramString1.setOnClickListener(this.mYg);
          paramString1.setClickable(this.nbl);
          paramObject1 = localLinearLayout.findViewById(2131824374);
          paramObject1.getLayoutParams().height = paramInt;
          paramObject1.setVisibility(0);
          this.nbi.put(Integer.valueOf(m.a((JSONObject)paramObject3, paramString3, getContext())), paramString1);
          bN(paramObject3);
        }
      }
      this.nbh.add(localLinearLayout);
      addView(localLinearLayout);
    }
    AppMethodBeat.o(62152);
  }
  
  public final void aa(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(62148);
    bDl();
    try
    {
      if (!ab(paramJSONObject)) {
        bDm();
      }
      AppMethodBeat.o(62148);
      return;
    }
    catch (Exception paramJSONObject)
    {
      bDm();
      AppMethodBeat.o(62148);
    }
  }
  
  protected boolean ab(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(62150);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(62150);
      return false;
    }
    paramJSONObject.optString("title");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("items");
    if (localJSONArray == null)
    {
      AppMethodBeat.o(62150);
      return false;
    }
    int i;
    int j;
    Object localObject2;
    Object localObject1;
    String str;
    label87:
    JSONObject localJSONObject;
    if (aa.gP(ah.getContext()).equalsIgnoreCase("en"))
    {
      i = a.ao(getContext(), 2131427504);
      j = 0;
      localObject2 = null;
      localObject1 = null;
      str = null;
      paramJSONObject = null;
      if (j >= Math.min(localJSONArray.length(), 9)) {
        break label208;
      }
      localJSONObject = localJSONArray.optJSONObject(j);
      if (j % 3 != 0) {
        break label148;
      }
      paramJSONObject = localJSONObject.optString("hotword");
      localObject1 = localJSONObject;
    }
    for (;;)
    {
      j += 1;
      break label87;
      i = a.ao(getContext(), 2131427809);
      break;
      label148:
      if (j % 3 == 1)
      {
        str = localJSONObject.optString("hotword");
        localObject2 = localJSONObject;
      }
      else
      {
        a(paramJSONObject, localObject1, str, localObject2, localJSONObject.optString("hotword"), localJSONObject, i);
        localObject2 = null;
        localObject1 = null;
        str = null;
        paramJSONObject = null;
      }
    }
    label208:
    if ((paramJSONObject != null) && (localObject1 != null)) {
      a(paramJSONObject, localObject1, str, localObject2, null, null, i);
    }
    AppMethodBeat.o(62150);
    return true;
  }
  
  protected void bDn() {}
  
  /* Error */
  public final void bJ()
  {
    // Byte code:
    //   0: ldc_w 400
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 355	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:bDl	()V
    //   10: aload_0
    //   11: ldc_w 402
    //   14: invokestatic 408	com/tencent/mm/plugin/websearch/api/ac:agv	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   17: invokevirtual 359	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:ab	(Lorg/json/JSONObject;)Z
    //   20: ifne +7 -> 27
    //   23: aload_0
    //   24: invokespecial 361	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:bDm	()V
    //   27: aload_0
    //   28: getfield 70	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:nbn	Z
    //   31: ifeq +91 -> 122
    //   34: ldc_w 410
    //   37: invokestatic 408	com/tencent/mm/plugin/websearch/api/ac:agv	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   40: ldc_w 366
    //   43: invokevirtual 370	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   46: iconst_0
    //   47: invokevirtual 396	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   50: ldc_w 398
    //   53: invokevirtual 147	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: aload_2
    //   58: invokestatic 153	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   61: ifne +61 -> 122
    //   64: aload_0
    //   65: invokevirtual 54	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:getContext	()Landroid/content/Context;
    //   68: ldc_w 411
    //   71: aconst_null
    //   72: invokestatic 290	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   75: checkcast 4	android/widget/LinearLayout
    //   78: astore_3
    //   79: aload_3
    //   80: ldc_w 412
    //   83: invokevirtual 295	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   86: checkcast 213	android/widget/TextView
    //   89: aload_2
    //   90: invokevirtual 299	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   93: aload_3
    //   94: aload_0
    //   95: getfield 414	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:nbp	Landroid/view/View$OnClickListener;
    //   98: invokevirtual 415	android/widget/LinearLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   101: aload_3
    //   102: aload_2
    //   103: invokevirtual 416	android/widget/LinearLayout:setTag	(Ljava/lang/Object;)V
    //   106: aload_0
    //   107: aload_3
    //   108: invokevirtual 348	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:addView	(Landroid/view/View;)V
    //   111: aload_0
    //   112: getfield 85	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:nbh	Ljava/util/List;
    //   115: aload_3
    //   116: invokeinterface 345 2 0
    //   121: pop
    //   122: aload_0
    //   123: getfield 418	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:nbo	Z
    //   126: ifeq +446 -> 572
    //   129: ldc_w 420
    //   132: invokestatic 426	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   135: checkcast 420	com/tencent/mm/plugin/appbrand/service/n
    //   138: invokeinterface 430 1 0
    //   143: astore_3
    //   144: aload_3
    //   145: getfield 434	com/tencent/mm/plugin/appbrand/service/n$b:items	Ljava/util/List;
    //   148: ifnull +424 -> 572
    //   151: aload_3
    //   152: getfield 434	com/tencent/mm/plugin/appbrand/service/n$b:items	Ljava/util/List;
    //   155: invokeinterface 437 1 0
    //   160: ifle +412 -> 572
    //   163: aload_0
    //   164: invokevirtual 54	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:getContext	()Landroid/content/Context;
    //   167: ldc_w 438
    //   170: aconst_null
    //   171: invokestatic 290	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   174: checkcast 4	android/widget/LinearLayout
    //   177: astore_2
    //   178: aload_2
    //   179: ldc_w 439
    //   182: invokevirtual 295	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   185: checkcast 213	android/widget/TextView
    //   188: aload_3
    //   189: getfield 442	com/tencent/mm/plugin/appbrand/service/n$b:cyA	Ljava/lang/String;
    //   192: invokevirtual 299	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   195: iconst_4
    //   196: anewarray 444	android/widget/ImageView
    //   199: astore 4
    //   201: aload 4
    //   203: iconst_0
    //   204: aload_2
    //   205: ldc_w 445
    //   208: invokevirtual 295	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   211: checkcast 444	android/widget/ImageView
    //   214: aastore
    //   215: aload 4
    //   217: iconst_1
    //   218: aload_2
    //   219: ldc_w 446
    //   222: invokevirtual 295	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   225: checkcast 444	android/widget/ImageView
    //   228: aastore
    //   229: aload 4
    //   231: iconst_2
    //   232: aload_2
    //   233: ldc_w 447
    //   236: invokevirtual 295	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   239: checkcast 444	android/widget/ImageView
    //   242: aastore
    //   243: aload 4
    //   245: iconst_3
    //   246: aload_2
    //   247: ldc_w 448
    //   250: invokevirtual 295	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   253: checkcast 444	android/widget/ImageView
    //   256: aastore
    //   257: aload_2
    //   258: ldc_w 449
    //   261: invokevirtual 295	android/widget/LinearLayout:findViewById	(I)Landroid/view/View;
    //   264: checkcast 444	android/widget/ImageView
    //   267: astore 5
    //   269: iconst_0
    //   270: istore_1
    //   271: iload_1
    //   272: aload_3
    //   273: getfield 434	com/tencent/mm/plugin/appbrand/service/n$b:items	Ljava/util/List;
    //   276: invokeinterface 437 1 0
    //   281: if_icmpge +116 -> 397
    //   284: iload_1
    //   285: iconst_4
    //   286: if_icmpge +111 -> 397
    //   289: aload_3
    //   290: getfield 434	com/tencent/mm/plugin/appbrand/service/n$b:items	Ljava/util/List;
    //   293: iload_1
    //   294: invokeinterface 452 2 0
    //   299: checkcast 454	com/tencent/mm/plugin/appbrand/service/n$c
    //   302: astore 6
    //   304: new 456	com/tencent/mm/at/a/a/c$a
    //   307: dup
    //   308: invokespecial 457	com/tencent/mm/at/a/a/c$a:<init>	()V
    //   311: astore 7
    //   313: aload 7
    //   315: ldc_w 458
    //   318: putfield 461	com/tencent/mm/at/a/a/c$a:eNY	I
    //   321: aload 7
    //   323: iconst_1
    //   324: putfield 464	com/tencent/mm/at/a/a/c$a:eOk	Z
    //   327: invokestatic 470	com/tencent/mm/at/o:ahG	()Lcom/tencent/mm/at/a/a;
    //   330: aload 6
    //   332: getfield 473	com/tencent/mm/plugin/appbrand/service/n$c:hcN	Ljava/lang/String;
    //   335: aload 4
    //   337: iload_1
    //   338: aaload
    //   339: aload 7
    //   341: invokevirtual 477	com/tencent/mm/at/a/a/c$a:ahY	()Lcom/tencent/mm/at/a/a/c;
    //   344: invokevirtual 482	com/tencent/mm/at/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/at/a/a/c;)V
    //   347: aload 4
    //   349: iload_1
    //   350: aaload
    //   351: iconst_0
    //   352: invokevirtual 483	android/widget/ImageView:setVisibility	(I)V
    //   355: aload 4
    //   357: iload_1
    //   358: aaload
    //   359: aload 6
    //   361: invokevirtual 484	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   364: aload_0
    //   365: getfield 486	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:nbq	Landroid/view/View$OnClickListener;
    //   368: ifnull +14 -> 382
    //   371: aload 4
    //   373: iload_1
    //   374: aaload
    //   375: aload_0
    //   376: getfield 486	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:nbq	Landroid/view/View$OnClickListener;
    //   379: invokevirtual 487	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   382: iload_1
    //   383: iconst_1
    //   384: iadd
    //   385: istore_1
    //   386: goto -115 -> 271
    //   389: astore_2
    //   390: aload_0
    //   391: invokespecial 361	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:bDm	()V
    //   394: goto -367 -> 27
    //   397: aload_3
    //   398: getfield 434	com/tencent/mm/plugin/appbrand/service/n$b:items	Ljava/util/List;
    //   401: invokeinterface 437 1 0
    //   406: ifle +26 -> 432
    //   409: aload 5
    //   411: iconst_0
    //   412: invokevirtual 483	android/widget/ImageView:setVisibility	(I)V
    //   415: aload 5
    //   417: ldc_w 489
    //   420: invokevirtual 484	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   423: aload 5
    //   425: aload_0
    //   426: getfield 486	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:nbq	Landroid/view/View$OnClickListener;
    //   429: invokevirtual 487	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   432: aload_0
    //   433: aload_2
    //   434: invokevirtual 348	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:addView	(Landroid/view/View;)V
    //   437: aload_0
    //   438: getfield 85	com/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout:nbh	Ljava/util/List;
    //   441: aload_2
    //   442: invokeinterface 345 2 0
    //   447: pop
    //   448: aload_3
    //   449: getfield 434	com/tencent/mm/plugin/appbrand/service/n$b:items	Ljava/util/List;
    //   452: invokeinterface 91 1 0
    //   457: astore 4
    //   459: ldc 48
    //   461: astore_2
    //   462: aload 4
    //   464: invokeinterface 97 1 0
    //   469: ifeq +47 -> 516
    //   472: aload 4
    //   474: invokeinterface 101 1 0
    //   479: checkcast 454	com/tencent/mm/plugin/appbrand/service/n$c
    //   482: astore 5
    //   484: new 160	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   491: aload_2
    //   492: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 5
    //   497: getfield 492	com/tencent/mm/plugin/appbrand/service/n$c:username	Ljava/lang/String;
    //   500: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 494
    //   506: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: astore_2
    //   513: goto -51 -> 462
    //   516: getstatic 500	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   519: sipush 14630
    //   522: iconst_5
    //   523: anewarray 187	java/lang/Object
    //   526: dup
    //   527: iconst_0
    //   528: getstatic 505	com/tencent/mm/plugin/fts/a/e:mRk	J
    //   531: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   534: aastore
    //   535: dup
    //   536: iconst_1
    //   537: aload_3
    //   538: getfield 442	com/tencent/mm/plugin/appbrand/service/n$b:cyA	Ljava/lang/String;
    //   541: aastore
    //   542: dup
    //   543: iconst_2
    //   544: aload_2
    //   545: aastore
    //   546: dup
    //   547: iconst_3
    //   548: aload_3
    //   549: getfield 508	com/tencent/mm/plugin/appbrand/service/n$b:iJv	I
    //   552: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   555: aastore
    //   556: dup
    //   557: iconst_4
    //   558: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   561: ldc2_w 509
    //   564: ldiv
    //   565: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   568: aastore
    //   569: invokevirtual 514	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   572: ldc_w 400
    //   575: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   578: return
    //   579: astore_2
    //   580: goto -458 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	FTSMainUIEducationLayout
    //   270	116	1	i	int
    //   56	202	2	localObject1	Object
    //   389	53	2	localException1	Exception
    //   461	84	2	str	String
    //   579	1	2	localException2	Exception
    //   78	471	3	localObject2	Object
    //   199	274	4	localObject3	Object
    //   267	229	5	localObject4	Object
    //   302	58	6	localc	com.tencent.mm.plugin.appbrand.service.n.c
    //   311	29	7	locala	com.tencent.mm.at.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   10	27	389	java/lang/Exception
    //   27	122	579	java/lang/Exception
  }
  
  public String getVertBizTypes()
  {
    if (this.nbj == null) {
      return "";
    }
    return this.nbj;
  }
  
  public void setCellClickable(boolean paramBoolean)
  {
    this.nbl = paramBoolean;
  }
  
  public void setNeedHotWord(boolean paramBoolean)
  {
    this.nbn = paramBoolean;
  }
  
  public void setNeedWXAPP(boolean paramBoolean)
  {
    this.nbo = paramBoolean;
  }
  
  public void setOnCellClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mYg = paramOnClickListener;
  }
  
  public void setOnHotwordClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nbp = paramOnClickListener;
  }
  
  public void setOnWxAppClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nbq = paramOnClickListener;
  }
  
  public void setSelected(int paramInt)
  {
    AppMethodBeat.i(62154);
    Iterator localIterator = this.nbi.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getKey()).intValue() == paramInt) {
        ((TextView)localEntry.getValue()).setTextColor(Color.parseColor("#B5B5B5"));
      } else {
        ((TextView)localEntry.getValue()).setTextColor(getContext().getResources().getColor(2131690701));
      }
    }
    AppMethodBeat.o(62154);
  }
  
  public final String wC(int paramInt)
  {
    AppMethodBeat.i(62155);
    Object localObject = (TextView)this.nbi.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      AppMethodBeat.o(62155);
      return "";
    }
    localObject = ((TextView)localObject).getText().toString();
    AppMethodBeat.o(62155);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout
 * JD-Core Version:    0.7.0.1
 */