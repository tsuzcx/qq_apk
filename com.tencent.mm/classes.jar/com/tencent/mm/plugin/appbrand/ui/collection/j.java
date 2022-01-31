package com.tencent.mm.plugin.appbrand.ui.collection;

import a.h.e;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.y.g;
import java.util.regex.Pattern;

public class j
  extends RecyclerView.v
  implements View.OnClickListener
{
  private final TextView hgE;
  private final TextView hgF;
  final ImageView hgG;
  final View hgH;
  LocalUsageInfo hgI;
  
  public j(View paramView)
  {
    super(paramView);
    paramView.setOnClickListener((View.OnClickListener)this);
    View localView = paramView.findViewById(y.g.primary_text);
    a.d.b.g.j(localView, "itemView.findViewById(R.id.primary_text)");
    this.hgE = ((TextView)localView);
    localView = paramView.findViewById(y.g.tag_text);
    a.d.b.g.j(localView, "itemView.findViewById(R.id.tag_text)");
    this.hgF = ((TextView)localView);
    localView = paramView.findViewById(y.g.icon);
    a.d.b.g.j(localView, "itemView.findViewById(R.id.icon)");
    this.hgG = ((ImageView)localView);
    paramView = paramView.findViewById(y.g.divider);
    a.d.b.g.j(paramView, "itemView.findViewById(R.id.divider)");
    this.hgH = paramView;
  }
  
  final void apG()
  {
    b localb = b.JD();
    ImageView localImageView = this.hgG;
    LocalUsageInfo localLocalUsageInfo = this.hgI;
    if (localLocalUsageInfo == null) {
      a.d.b.g.cUk();
    }
    localb.a(localImageView, localLocalUsageInfo.fJY, com.tencent.mm.modelappbrand.a.a.JC(), (b.f)f.eaL);
  }
  
  final void apH()
  {
    Object localObject1 = this.hgI;
    if (localObject1 == null) {
      a.d.b.g.cUk();
    }
    localObject1 = ((LocalUsageInfo)localObject1).nickname;
    TextView localTextView = this.hgE;
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label271;
      }
      localObject1 = this.hgI;
      if (localObject1 == null) {
        a.d.b.g.cUk();
      }
      localObject1 = ((LocalUsageInfo)localObject1).username;
      a.d.b.g.j(localObject1, "itemInfo!!.username");
      localObject2 = Pattern.quote("@app");
      a.d.b.g.j(localObject2, "Pattern.quote(ConstantsStorage.TAG_APPBRAND)");
      a.d.b.g.k(localObject1, "$receiver");
      a.d.b.g.k(localObject2, "oldValue");
      a.d.b.g.k("", "newValue");
      i = e.b((CharSequence)localObject1, (String)localObject2, 0, 2);
      if (i >= 0) {
        break label140;
      }
    }
    label123:
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)localObject1)
    {
      localTextView.setText((CharSequence)localObject1);
      return;
      i = 0;
      break;
      int j = i + ((String)localObject2).length();
      localObject1 = (CharSequence)localObject1;
      localObject2 = (CharSequence)"";
      a.d.b.g.k(localObject1, "$receiver");
      a.d.b.g.k(localObject2, "replacement");
      if (j < i) {
        throw ((Throwable)new IndexOutOfBoundsException("End index (" + j + ") is less than start index (" + i + ")."));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((CharSequence)localObject1, 0, i);
      localStringBuilder.append((CharSequence)localObject2);
      localStringBuilder.append((CharSequence)localObject1, j, ((CharSequence)localObject1).length());
      localObject1 = ((CharSequence)localStringBuilder).toString();
      break label123;
    }
  }
  
  public final void f(LocalUsageInfo paramLocalUsageInfo)
  {
    a.d.b.g.k(paramLocalUsageInfo, "dataItem");
    this.hgI = paramLocalUsageInfo;
    paramLocalUsageInfo = com.tencent.mm.plugin.appbrand.appcache.a.kp(paramLocalUsageInfo.fJy);
    CharSequence localCharSequence = (CharSequence)paramLocalUsageInfo;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label66;
      }
      this.hgF.setVisibility(8);
    }
    for (;;)
    {
      apH();
      apG();
      return;
      i = 0;
      break;
      label66:
      this.hgF.setVisibility(0);
      this.hgF.setText((CharSequence)paramLocalUsageInfo);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.hgI;
    if (localObject != null)
    {
      com.tencent.mm.plugin.appbrand.launching.precondition.g localg = com.tencent.mm.plugin.appbrand.launching.precondition.g.gMF;
      if (paramView == null) {
        a.d.b.g.cUk();
      }
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject).username;
      String str2 = ((LocalUsageInfo)localObject).appId;
      int i = ((LocalUsageInfo)localObject).fJy;
      localObject = new AppBrandStatObject();
      ((AppBrandStatObject)localObject).scene = 1103;
      localg.a(paramView, str1, str2, null, i, 0, (AppBrandStatObject)localObject, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.j
 * JD-Core Version:    0.7.0.1
 */