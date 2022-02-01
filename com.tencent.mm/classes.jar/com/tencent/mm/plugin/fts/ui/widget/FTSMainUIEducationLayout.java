package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.c.k;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.b;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayout
  extends LinearLayout
{
  protected List<LinearLayout> HCK;
  protected Map<Integer, TextView> HCL;
  private boolean HCM;
  protected boolean HCN;
  protected View.OnClickListener HCO;
  boolean HzM;
  
  public FTSMainUIEducationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112267);
    this.HCL = new HashMap();
    this.HCM = true;
    this.HCN = true;
    this.HzM = false;
    initView();
    AppMethodBeat.o(112267);
  }
  
  public FTSMainUIEducationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112268);
    this.HCL = new HashMap();
    this.HCM = true;
    this.HCN = true;
    this.HzM = false;
    initView();
    AppMethodBeat.o(112268);
  }
  
  private void a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, String paramString3, Object paramObject3, int paramInt)
  {
    AppMethodBeat.i(112275);
    Log.i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
    if (!Util.isNullOrNil(paramString1))
    {
      LinearLayout localLinearLayout = (LinearLayout)inflate(getContext(), p.e.fts_main_ui_education_cell_layout, null);
      View localView1 = localLinearLayout.findViewById(p.d.cell_1);
      TextView localTextView = (TextView)localLinearLayout.findViewById(p.d.textview_1);
      localTextView.setText(paramString1);
      localTextView.setTextSize(0, a.bs(getContext(), p.b.NormalTextSize) * a.jO(getContext()));
      localTextView.setContentDescription(paramString1 + getResources().getString(p.g.fts_search_biz_btn));
      localView1.setTag(paramObject1);
      localView1.setTag(p.d.tv_content, localTextView);
      localView1.setTag(p.d.is_cell_layout, Boolean.TRUE);
      View localView2 = localLinearLayout.findViewById(p.d.red_dot_1);
      localView1.setTag(p.d.red_dot, localView2);
      f(paramObject1, localView2);
      localView1.setVisibility(0);
      localTextView.setVisibility(0);
      localView1.setOnClickListener(this.HCO);
      localView1.setClickable(this.HCM);
      this.HCL.put(Integer.valueOf(o.a((JSONObject)paramObject1, paramString1, getContext())), localTextView);
      if (!Util.isNullOrNil(paramString2))
      {
        paramObject1 = localLinearLayout.findViewById(p.d.cell_2);
        paramString1 = (TextView)localLinearLayout.findViewById(p.d.textview_2);
        paramString1.setText(paramString2);
        paramString1.setTextSize(0, a.bs(getContext(), p.b.NormalTextSize) * a.jO(getContext()));
        paramString1.setContentDescription(paramString2 + getResources().getString(p.g.fts_search_biz_btn));
        paramString1.setVisibility(0);
        paramObject1.setTag(paramObject2);
        paramObject1.setTag(p.d.tv_content, paramString1);
        paramObject1.setTag(p.d.is_cell_layout, Boolean.TRUE);
        localView1 = localLinearLayout.findViewById(p.d.red_dot_2);
        paramObject1.setTag(p.d.red_dot, localView1);
        f(paramObject2, localView1);
        paramObject1.setVisibility(0);
        paramObject1.setOnClickListener(this.HCO);
        paramObject1.setClickable(this.HCM);
        paramObject1 = localLinearLayout.findViewById(p.d.divider_1);
        paramObject1.getLayoutParams().height = paramInt;
        paramObject1.setVisibility(0);
        this.HCL.put(Integer.valueOf(o.a((JSONObject)paramObject2, paramString2, getContext())), paramString1);
        if (!Util.isNullOrNil(paramString3))
        {
          paramObject1 = localLinearLayout.findViewById(p.d.cell_3);
          paramString1 = (TextView)localLinearLayout.findViewById(p.d.textview_3);
          paramString1.setText(paramString3);
          paramString1.setTextSize(0, a.bs(getContext(), p.b.NormalTextSize) * a.jO(getContext()));
          paramString1.setContentDescription(paramString3 + getResources().getString(p.g.fts_search_biz_btn));
          paramString1.setVisibility(0);
          paramObject1.setTag(paramObject3);
          paramObject1.setTag(p.d.tv_content, paramString1);
          paramObject1.setTag(p.d.is_cell_layout, Boolean.TRUE);
          paramString2 = localLinearLayout.findViewById(p.d.red_dot_3);
          paramObject1.setTag(p.d.red_dot, paramString2);
          f(paramObject3, paramString2);
          paramObject1.setVisibility(0);
          paramObject1.setOnClickListener(this.HCO);
          paramObject1.setClickable(this.HCM);
          paramObject1 = localLinearLayout.findViewById(p.d.divider_2);
          paramObject1.getLayoutParams().height = paramInt;
          paramObject1.setVisibility(0);
          this.HCL.put(Integer.valueOf(o.a((JSONObject)paramObject3, paramString3, getContext())), paramString1);
        }
      }
      this.HCK.add(localLinearLayout);
      addView(localLinearLayout);
    }
    AppMethodBeat.o(112275);
  }
  
  private static void f(Object paramObject, View paramView)
  {
    AppMethodBeat.i(265878);
    if (((paramObject instanceof JSONObject)) && (paramView != null))
    {
      int i = ((JSONObject)paramObject).optInt("businessType");
      paramObject = k.HBV;
      if (k.ru(i))
      {
        paramView.setVisibility(0);
        paramObject = k.HBV;
        k.rv(i);
        AppMethodBeat.o(265878);
        return;
      }
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(265878);
  }
  
  private void fzh()
  {
    AppMethodBeat.i(112274);
    a(getContext().getString(p.g.search_education_timeline), null, getContext().getString(p.g.search_education_article), null, getContext().getString(p.g.search_education_biz_contact), null, a.br(getContext(), p.b.NormalTextSize));
    AppMethodBeat.o(112274);
  }
  
  private void initView()
  {
    AppMethodBeat.i(112269);
    setOrientation(1);
    this.HCK = new ArrayList();
    AppMethodBeat.o(112269);
  }
  
  public void setNeedHotWord(boolean paramBoolean)
  {
    this.HCN = paramBoolean;
  }
  
  public void setOnCellClickListener(View.OnClickListener paramOnClickListener)
  {
    this.HCO = paramOnClickListener;
  }
  
  public final void updateView()
  {
    int k = 0;
    AppMethodBeat.i(112270);
    Object localObject1 = this.HCK.iterator();
    while (((Iterator)localObject1).hasNext()) {
      removeView((LinearLayout)((Iterator)localObject1).next());
    }
    this.HCK.clear();
    this.HCL.clear();
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject1 = al.bix("educationTab");
        if (localObject1 == null)
        {
          i = 0;
          if (i == 0) {
            fzh();
          }
          AppMethodBeat.o(112270);
          return;
        }
        JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("items");
        if (localJSONArray == null)
        {
          i = 0;
          continue;
        }
        JSONObject localJSONObject2;
        if (LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()).equalsIgnoreCase("en"))
        {
          i = a.br(getContext(), p.b.BiggerMoreTextSize);
          break label448;
          if (j >= Math.min(localJSONArray.length(), 9)) {
            continue;
          }
          localJSONObject2 = localJSONArray.optJSONObject(j);
          if (j % 3 == 0)
          {
            localObject1 = localJSONObject2.optString("hotword");
            localObject3 = localJSONObject2;
            break label465;
          }
        }
        else
        {
          i = a.br(getContext(), p.b.NormalTextSize);
          break label448;
        }
        if (j % 3 == 1)
        {
          localObject4 = localJSONObject2.optString("hotword");
          localJSONObject1 = localJSONObject2;
          break label465;
        }
        a((String)localObject1, localObject3, (String)localObject4, localJSONObject1, localJSONObject2.optString("hotword"), localJSONObject2, i);
        localJSONObject1 = null;
        localObject3 = null;
        localObject4 = null;
        localObject1 = null;
        break label465;
        if ((localObject1 != null) && (localObject3 != null)) {
          a((String)localObject1, localObject3, (String)localObject4, localJSONObject1, null, null, i);
        }
        if (!this.HzM)
        {
          this.HzM = true;
          if (localJSONArray != null)
          {
            localObject3 = new StringBuilder();
            i = k;
            if (i < localJSONArray.length())
            {
              localObject1 = localJSONArray.optJSONObject(i);
              if (localObject1 == null) {
                break label472;
              }
              j = ((JSONObject)localObject1).optInt("businessType");
              localObject1 = "";
              localObject4 = k.HBV;
              if (k.ru(j))
              {
                localObject1 = k.HBV;
                localObject1 = k.rt(j);
              }
              if (((StringBuilder)localObject3).length() > 0) {
                ((StringBuilder)localObject3).append(";");
              }
              ((StringBuilder)localObject3).append(j);
              ((StringBuilder)localObject3).append("#").append((String)localObject1);
              break label472;
            }
            as.nV(e.fxw(), ((StringBuilder)localObject3).toString());
          }
        }
        i = 1;
        continue;
        j = 0;
      }
      catch (Exception localException)
      {
        fzh();
        AppMethodBeat.o(112270);
        return;
      }
      label448:
      JSONObject localJSONObject1 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject2 = null;
      continue;
      label465:
      j += 1;
      continue;
      label472:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout
 * JD-Core Version:    0.7.0.1
 */