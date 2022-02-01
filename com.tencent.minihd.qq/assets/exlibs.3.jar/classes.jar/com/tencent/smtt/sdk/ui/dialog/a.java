package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.ui.dialog.widget.RoundImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends ArrayAdapter<b>
  implements View.OnClickListener, ListAdapter
{
  private ArrayList<b> a;
  private b b = null;
  private Intent c;
  private WeakReference<ListView> d;
  private WeakReference<d> e;
  private b f;
  private b g;
  private List<b> h;
  private Handler i;
  private String[] j;
  
  public a(Context paramContext, Intent paramIntent, b paramb1, List<b> paramList, b paramb2, d paramd, ListView paramListView)
  {
    super(paramContext, 0);
    a(paramd);
    a(paramListView);
    this.g = paramb1;
    this.c = paramIntent;
    if (("com.tencent.rtxlite".equalsIgnoreCase(paramContext.getApplicationContext().getPackageName())) || (MttLoader.isBrowserInstalled(paramContext))) {}
    for (this.f = null;; this.f = this.g)
    {
      this.h = paramList;
      this.i = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          }
          a.this.b();
        }
      };
      this.j = new String[2];
      this.j[0] = e.b("x5_tbs_activity_picker_recommend_to_trim");
      this.j[1] = e.b("x5_tbs_activity_picker_recommend_with_chinese_brace_to_trim");
      a(paramContext, paramb2);
      return;
    }
  }
  
  private View a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOrientation(1);
    Object localObject1 = new StateListDrawable();
    Object localObject2 = new ColorDrawable(Color.argb(41, 0, 0, 0));
    ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
    localObject2 = new ColorDrawable(0);
    ((StateListDrawable)localObject1).addState(new int[] { -16842919 }, (Drawable)localObject2);
    localLinearLayout.setBackgroundDrawable((Drawable)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, c.a(getContext(), 144.0F)));
    localObject2 = new RoundImageView(paramContext);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    Object localObject3 = new RelativeLayout.LayoutParams(c.a(getContext(), 96.0F), c.a(getContext(), 96.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(c.a(getContext(), 32.0F), c.a(getContext(), 24.0F), c.a(getContext(), 24.0F), c.a(getContext(), 24.0F));
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setId(101);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, 101);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setMaxLines(1);
    ((TextView)localObject3).setTextColor(Color.rgb(29, 29, 29));
    ((TextView)localObject3).setTextSize(1, 17.0F);
    ((TextView)localObject3).setId(102);
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setText(e.b("x5_tbs_wechat_activity_picker_label_recommend"));
    ((TextView)localObject3).setTextColor(Color.parseColor("#00CAFC"));
    ((TextView)localObject3).setTextSize(1, 14.0F);
    ((TextView)localObject3).setId(103);
    ((LinearLayout)localObject2).addView((View)localObject3);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    paramContext = new ImageView(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(c.a(getContext(), 48.0F), c.a(getContext(), 48.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, c.a(getContext(), 32.0F), 0);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.setImageDrawable(e.a("x5_tbs_activity_picker_check"));
    paramContext.setId(104);
    ((RelativeLayout)localObject1).addView(paramContext);
    ((RelativeLayout)localObject1).setId(105);
    localLinearLayout.addView((View)localObject1);
    return localLinearLayout;
  }
  
  private void a(b paramb, View paramView)
  {
    if ((paramView == null) || (paramb == null)) {
      return;
    }
    Object localObject1 = (ImageView)paramView.findViewById(101);
    TextView localTextView1 = (TextView)paramView.findViewById(102);
    TextView localTextView2 = (TextView)paramView.findViewById(103);
    ImageView localImageView = (ImageView)paramView.findViewById(104);
    View localView1 = paramView.findViewById(105);
    View localView2 = paramView.findViewById(106);
    ((ImageView)localObject1).setImageDrawable(paramb.a());
    localObject1 = paramb.b().trim().replaceAll(' ' + "", "");
    String[] arrayOfString = this.j;
    int m = arrayOfString.length;
    int k = 0;
    while (k < m)
    {
      String str = arrayOfString[k];
      Object localObject2 = localObject1;
      if (str != null)
      {
        localObject2 = localObject1;
        if (str.length() > 0) {
          localObject2 = ((String)localObject1).replaceAll(str, "");
        }
      }
      k += 1;
      localObject1 = localObject2;
    }
    localTextView1.setText((CharSequence)localObject1);
    if (paramb.c() == null) {
      paramb.a(a(paramb));
    }
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = paramAnonymousView.getParent();
        if (!(paramAnonymousView instanceof View)) {}
        do
        {
          return;
          paramAnonymousView = (View)paramAnonymousView;
        } while (paramAnonymousView.getTag() != a.a(a.this));
        a.this.onClick(paramAnonymousView);
      }
    });
    if ("com.tencent.mtt".equals(paramb.d()))
    {
      localTextView2.setVisibility(0);
      localTextView2.setText(paramb.h());
      localView1.setClickable(false);
      localView1.setEnabled(false);
      if (paramb != this.b) {
        break label306;
      }
      localImageView.setVisibility(0);
      if (localView2 != null) {
        localView2.setVisibility(0);
      }
    }
    for (;;)
    {
      paramView.setTag(paramb);
      paramView.setOnClickListener(this);
      return;
      localTextView2.setVisibility(8);
      break;
      label306:
      localImageView.setVisibility(8);
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.e == null) {}
    d locald;
    do
    {
      return;
      locald = (d)this.e.get();
    } while (locald == null);
    locald.a(paramBoolean);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private void b(Context paramContext, b paramb)
  {
    this.b = paramb;
    if (this.b == null) {
      return;
    }
    if ((this.b.e()) || (this.b.f()))
    {
      a(true);
      return;
    }
    a(a(paramContext, this.b.d()));
  }
  
  public ResolveInfo a(b paramb)
  {
    if ((paramb == null) || (TextUtils.isEmpty(paramb.d()))) {
      return null;
    }
    Iterator localIterator = getContext().getPackageManager().queryIntentActivities(this.c, 65536).iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if (paramb.d().equals(localResolveInfo.activityInfo.packageName)) {
        return localResolveInfo;
      }
    }
    return null;
  }
  
  public b a()
  {
    return this.b;
  }
  
  public b a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.size())) {
      return null;
    }
    return (b)this.a.get(paramInt);
  }
  
  void a(Context paramContext, b paramb)
  {
    this.a = new ArrayList();
    if ((this.h != null) && (this.h.size() != 0)) {
      this.a.addAll(this.h);
    }
    Iterator localIterator = paramContext.getPackageManager().queryIntentActivities(this.c, 65536).iterator();
    int k = 0;
    int m = 0;
    ResolveInfo localResolveInfo;
    b localb;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localResolveInfo = (ResolveInfo)localIterator.next();
        if ((b.a(paramContext, localResolveInfo.activityInfo.packageName) != null) || (localResolveInfo.loadIcon(paramContext.getPackageManager()) != null))
        {
          localb = new b(paramContext, localResolveInfo);
          if ((this.f != null) && (this.f.d().equals(localResolveInfo.activityInfo.packageName)))
          {
            localb.a(this.f.f());
            localb.a(this.f.h());
            localb.a(this.f.a());
            this.a.add(0, localb);
            m = 1;
            label206:
            if ((k != 0) || (paramb == null) || (!localb.d().equals(paramb.d()))) {
              break label382;
            }
            b(paramContext, localb);
            k = 1;
          }
        }
      }
    }
    label382:
    for (;;)
    {
      break;
      if ("com.tencent.mtt".equals(localResolveInfo.activityInfo.packageName))
      {
        if (this.g != null)
        {
          localb.a(this.g.f());
          localb.a(this.g.h());
          localb.a(this.g.a());
        }
        this.a.add(0, localb);
        break label206;
      }
      this.a.add(localb);
      break label206;
      if ((m == 0) && (this.f != null)) {
        this.a.add(0, this.f);
      }
      if ((k == 0) && (this.a.size() > 0)) {
        b(paramContext, (b)this.a.get(0));
      }
      return;
    }
  }
  
  void a(ListView paramListView)
  {
    this.d = new WeakReference(paramListView);
  }
  
  void a(d paramd)
  {
    this.e = new WeakReference(paramd);
  }
  
  public void b()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.i.obtainMessage(1).sendToTarget();
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (ListView)this.d.get();
      } while (localObject == null);
      localObject = ((ListView)localObject).findViewWithTag(this.f);
    } while (localObject == null);
    a(this.f, (View)localObject);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = a(paramInt);
    if (paramViewGroup == null) {
      return null;
    }
    if (paramView != null) {}
    for (;;)
    {
      a(paramViewGroup, paramView);
      return paramView;
      paramView = a(getContext());
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    b localb1;
    if ((localObject != null) && ((localObject instanceof b)))
    {
      localb1 = (b)localObject;
      if (localb1 != this.b) {}
    }
    else
    {
      return;
    }
    localObject = paramView.getParent();
    if ((localObject instanceof View)) {}
    for (localObject = (View)localObject;; localObject = null)
    {
      b localb2 = this.b;
      b(paramView.getContext(), localb1);
      a(localb2, ((View)localObject).findViewWithTag(localb2));
      a(this.b, paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.a
 * JD-Core Version:    0.7.0.1
 */