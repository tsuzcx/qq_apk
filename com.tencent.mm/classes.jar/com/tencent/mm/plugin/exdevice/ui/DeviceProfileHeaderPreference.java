package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference
  extends Preference
{
  private CharSequence CQ;
  private String gnO;
  private String iZG;
  protected MMActivity iwz;
  private ImageView jAk;
  private TextView jAl;
  private TextView jAm;
  private TextView jAn;
  private View jAo;
  TextView jAp;
  private boolean[] jAq = new boolean[6];
  private View.OnClickListener[] jAr = new View.OnClickListener[6];
  String jAs;
  private boolean jAt = false;
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.iwz = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.iwz = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  private void H(View paramView, int paramInt)
  {
    if (this.jAq[paramInt] != 0) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      paramView.setOnClickListener(this.jAr[paramInt]);
      return;
    }
  }
  
  public final void BJ(String paramString)
  {
    this.gnO = paramString;
    if (this.jAn != null) {
      this.jAn.setText(paramString);
    }
  }
  
  public final void K(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    Object localObject;
    int j;
    switch (paramInt)
    {
    default: 
    case 0: 
      label60:
      do
      {
        return;
        localObject = this.jAk;
        boolean[] arrayOfBoolean = this.jAq;
        if (paramBoolean) {
          break;
        }
        j = 1;
        arrayOfBoolean[paramInt] = j;
      } while (localObject == null);
      if (!paramBoolean) {
        break;
      }
    }
    for (paramInt = i;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return;
      localObject = this.jAl;
      break;
      localObject = this.jAm;
      break;
      localObject = this.jAn;
      break;
      localObject = this.jAo;
      break;
      localObject = this.jAp;
      break;
      j = 0;
      break label60;
    }
  }
  
  public final void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localObject = this.jAk;
    }
    for (;;)
    {
      this.jAr[paramInt] = paramOnClickListener;
      if (localObject == null) {
        break;
      }
      ((View)localObject).setOnClickListener(paramOnClickListener);
      return;
      localObject = this.jAl;
      continue;
      localObject = this.jAm;
      continue;
      localObject = this.jAn;
      continue;
      localObject = this.jAo;
      continue;
      localObject = this.jAp;
    }
  }
  
  public final void onBindView(View paramView)
  {
    y.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
    this.jAk = ((ImageView)paramView.findViewById(R.h.avatarIV));
    this.jAl = ((TextView)paramView.findViewById(R.h.nameTV));
    this.jAm = ((TextView)paramView.findViewById(R.h.editRemarkTV));
    this.jAn = ((TextView)paramView.findViewById(R.h.deviceNameTV));
    this.jAo = paramView.findViewById(R.h.editTV);
    this.jAp = ((TextView)paramView.findViewById(R.h.deviceDescTV));
    H(this.jAk, 0);
    H(this.jAl, 2);
    H(this.jAm, 1);
    H(this.jAn, 3);
    H(this.jAo, 4);
    H(this.jAp, 5);
    this.jAt = true;
    if (!this.jAt) {
      y.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.jAt);
    }
    for (;;)
    {
      super.onBindView(paramView);
      return;
      this.jAl.setText(this.CQ);
      this.jAn.setText(this.gnO);
      this.jAp.setText(this.jAs);
      setIconUrl(this.iZG);
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    this.iZG = paramString;
    if (this.jAk != null)
    {
      c.a locala = new c.a();
      Bitmap localBitmap = c.EX(R.g.exdevice_my_device_default_icon);
      paramString = localBitmap;
      if (localBitmap != null)
      {
        paramString = localBitmap;
        if (!localBitmap.isRecycled())
        {
          localBitmap = c.a(localBitmap, true, 0.5F * localBitmap.getWidth());
          paramString = localBitmap;
          if (localBitmap != null)
          {
            paramString = localBitmap;
            if (!localBitmap.isRecycled())
            {
              locala.erv = new BitmapDrawable(localBitmap);
              paramString = localBitmap;
            }
          }
        }
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        locala.eru = R.g.exdevice_my_device_default_icon;
      }
      locala.erD = true;
      paramString = locala.OV();
      o.ON().a(this.iZG, this.jAk, paramString);
    }
  }
  
  public final void setName(CharSequence paramCharSequence)
  {
    this.CQ = paramCharSequence;
    if (this.jAl != null) {
      this.jAl.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */