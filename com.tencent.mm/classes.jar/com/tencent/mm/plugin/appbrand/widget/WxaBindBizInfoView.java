package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.z;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WxaBindBizInfoView
  extends LinearLayout
{
  private static int hop = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 15);
  private static int hoq = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 30);
  private TextView haW;
  public List<WxaAttributes.WxaEntryInfo> hoi;
  private View hoj;
  private ImageView hok;
  private TextView hol;
  private LinearLayout hom;
  private ViewGroup hon;
  private View hoo;
  
  public WxaBindBizInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public WxaBindBizInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private static void a(WxaAttributes.WxaEntryInfo paramWxaEntryInfo, ImageView paramImageView, TextView paramTextView)
  {
    Object localObject2 = null;
    if (paramWxaEntryInfo == null) {
      return;
    }
    Object localObject1 = paramWxaEntryInfo.username;
    Object localObject3;
    if (paramImageView != null)
    {
      paramImageView.setTag(localObject1);
      localObject3 = paramWxaEntryInfo.username;
      if (g.DP().isSDCardAvailable()) {
        break label74;
      }
      localObject1 = m.ip(0);
    }
    label42:
    label58:
    label74:
    do
    {
      do
      {
        do
        {
          do
          {
            if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
              break;
            }
            paramImageView.setImageBitmap((Bitmap)localObject1);
            if (paramTextView == null) {
              break label178;
            }
            paramTextView.setText(bk.pm(paramWxaEntryInfo.title));
            return;
            localObject1 = localObject2;
          } while (localObject3 == null);
          localObject1 = localObject2;
        } while (!g.DN().Dc());
        localObject1 = z.MI();
        if (!((m.a)localObject1).egG.containsKey(localObject3)) {
          break label180;
        }
        localObject3 = (Bitmap)((WeakReference)((m.a)localObject1).egG.get(localObject3)).get();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = localObject2;
    } while (((Bitmap)localObject3).isRecycled());
    label178:
    label180:
    for (localObject1 = localObject3;; localObject1 = null)
    {
      break label42;
      b.JD().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.JC(), f.eaL);
      break label58;
      break;
    }
  }
  
  private void init()
  {
    this.hoi = new LinkedList();
    View localView = View.inflate(getContext(), y.h.app_brand_profile_wxa_bind_biz_info_item, this);
    this.hoj = localView.findViewById(y.g.firstItemV);
    this.hok = ((ImageView)localView.findViewById(y.g.iconIv));
    this.haW = ((TextView)localView.findViewById(y.g.titleTv));
    this.hol = ((TextView)localView.findViewById(y.g.countTv));
    this.hoo = localView.findViewById(y.g.moreV);
    this.hom = ((LinearLayout)localView.findViewById(y.g.containerV));
    this.hon = ((ViewGroup)localView.findViewById(y.g.itemContainerV));
  }
  
  public final void dM(boolean paramBoolean)
  {
    if (this.hon.getMeasuredWidth() == 0)
    {
      if (paramBoolean) {
        getViewTreeObserver().addOnPreDrawListener(new WxaBindBizInfoView.1(this));
      }
      return;
    }
    Object localObject;
    int j;
    int k;
    int i;
    if (this.hoi.isEmpty())
    {
      setVisibility(8);
      localObject = null;
      if (localObject != null) {
        a((WxaAttributes.WxaEntryInfo)localObject, this.hok, this.haW);
      }
      this.hol.setText(getContext().getString(y.j.contact_info_bind_weapp_count, new Object[] { Integer.valueOf(this.hoi.size()) }));
      localObject = this.hoi;
      this.hom.removeAllViews();
      if (((List)localObject).isEmpty()) {
        break label366;
      }
      j = ((List)localObject).size();
      k = this.hon.getMeasuredWidth() - this.hon.getPaddingLeft() - this.hon.getPaddingRight();
      i = k / (hoq + hop);
      if (i <= j) {
        break label310;
      }
      this.hoo.setVisibility(8);
    }
    for (;;)
    {
      j = Math.min(i, j);
      if (j <= 1) {
        break label340;
      }
      i = 0;
      while (i < j)
      {
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)((List)localObject).get(i);
        ImageView localImageView = new ImageView(getContext());
        localImageView.setLayoutParams(new ViewGroup.LayoutParams(hoq + hop, hoq));
        localImageView.setPadding(0, 0, hop, 0);
        this.hom.addView(localImageView);
        a(localWxaEntryInfo, localImageView, null);
        i += 1;
      }
      setVisibility(0);
      localObject = (WxaAttributes.WxaEntryInfo)this.hoi.get(0);
      break;
      label310:
      this.hoo.setVisibility(0);
      i = (k - this.hoo.getMeasuredWidth()) / (hoq + hop);
    }
    label340:
    y.i("MicroMsg.WxaBindBizInfoView", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(((List)localObject).size()) });
    label366:
    if (this.hoi.size() == 1)
    {
      this.hoj.setVisibility(0);
      this.hon.setTag(((WxaAttributes.WxaEntryInfo)this.hoi.get(0)).username);
      return;
    }
    this.hoj.setVisibility(8);
    this.hon.setTag(null);
  }
  
  public List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    return this.hoi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView
 * JD-Core Version:    0.7.0.1
 */