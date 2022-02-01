package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference
  extends Preference
{
  private CharSequence ed;
  private String mDeviceName;
  protected MMActivity pVV;
  private String xOn;
  private ImageView yxi;
  private TextView yxj;
  private TextView yxk;
  private TextView yxl;
  private View yxm;
  private TextView yxn;
  private boolean[] yxo;
  private View.OnClickListener[] yxp;
  private String yxq;
  private boolean yxr;
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23827);
    this.yxo = new boolean[6];
    this.yxp = new View.OnClickListener[6];
    this.yxr = false;
    this.pVV = ((MMActivity)paramContext);
    this.yxr = false;
    AppMethodBeat.o(23827);
  }
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23828);
    this.yxo = new boolean[6];
    this.yxp = new View.OnClickListener[6];
    this.yxr = false;
    this.pVV = ((MMActivity)paramContext);
    this.yxr = false;
    AppMethodBeat.o(23828);
  }
  
  private void ah(View paramView, int paramInt)
  {
    AppMethodBeat.i(23830);
    if (this.yxo[paramInt] != 0) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      paramView.setOnClickListener(this.yxp[paramInt]);
      AppMethodBeat.o(23830);
      return;
    }
  }
  
  public final void BL(String paramString)
  {
    AppMethodBeat.i(23835);
    this.yxq = paramString;
    if (this.yxn != null) {
      this.yxn.setText(paramString);
    }
    AppMethodBeat.o(23835);
  }
  
  public final void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(23832);
    Object localObject;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(23832);
      return;
    case 0: 
      localObject = this.yxi;
    }
    for (;;)
    {
      this.yxp[paramInt] = paramOnClickListener;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(paramOnClickListener);
      }
      AppMethodBeat.o(23832);
      return;
      localObject = this.yxj;
      continue;
      localObject = this.yxk;
      continue;
      localObject = this.yxl;
      continue;
      localObject = this.yxm;
      continue;
      localObject = this.yxn;
    }
  }
  
  public final void apL(String paramString)
  {
    AppMethodBeat.i(23834);
    this.mDeviceName = paramString;
    if (this.yxl != null) {
      this.yxl.setText(paramString);
    }
    AppMethodBeat.o(23834);
  }
  
  public final void az(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(23831);
    Object localObject;
    int j;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(23831);
      return;
    case 0: 
      localObject = this.yxi;
      boolean[] arrayOfBoolean = this.yxo;
      if (!paramBoolean)
      {
        j = 1;
        label74:
        arrayOfBoolean[paramInt] = j;
        if (localObject != null) {
          if (!paramBoolean) {
            break label155;
          }
        }
      }
      break;
    }
    label155:
    for (paramInt = i;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      AppMethodBeat.o(23831);
      return;
      localObject = this.yxj;
      break;
      localObject = this.yxk;
      break;
      localObject = this.yxl;
      break;
      localObject = this.yxm;
      break;
      localObject = this.yxn;
      break;
      j = 0;
      break label74;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23829);
    Log.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
    this.yxi = ((ImageView)paramView.findViewById(R.h.avatarIV));
    this.yxj = ((TextView)paramView.findViewById(R.h.fOX));
    this.yxk = ((TextView)paramView.findViewById(R.h.fGu));
    this.yxl = ((TextView)paramView.findViewById(R.h.fFc));
    this.yxm = paramView.findViewById(R.h.fGv);
    this.yxn = ((TextView)paramView.findViewById(R.h.fFb));
    ah(this.yxi, 0);
    ah(this.yxj, 2);
    ah(this.yxk, 1);
    ah(this.yxl, 3);
    ah(this.yxm, 4);
    ah(this.yxn, 5);
    this.yxr = true;
    if (!this.yxr) {
      Log.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.yxr);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(23829);
      return;
      this.yxj.setText(this.ed);
      this.yxl.setText(this.mDeviceName);
      this.yxn.setText(this.yxq);
      setIconUrl(this.xOn);
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(23836);
    this.xOn = paramString;
    if (this.yxi != null)
    {
      c.a locala = new c.a();
      Bitmap localBitmap = BitmapUtil.getBitmapNative(R.g.fnH);
      paramString = localBitmap;
      if (localBitmap != null)
      {
        paramString = localBitmap;
        if (!localBitmap.isRecycled())
        {
          localBitmap = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, 0.5F * localBitmap.getWidth());
          paramString = localBitmap;
          if (localBitmap != null)
          {
            paramString = localBitmap;
            if (!localBitmap.isRecycled())
            {
              locala.npX = new BitmapDrawable(localBitmap);
              paramString = localBitmap;
            }
          }
        }
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        locala.oKB = R.g.fnH;
      }
      locala.nrc = true;
      paramString = locala.bKx();
      r.bKe().a(this.xOn, this.yxi, paramString);
    }
    AppMethodBeat.o(23836);
  }
  
  public final void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(23833);
    this.ed = paramCharSequence;
    if (this.yxj != null) {
      this.yxj.setText(paramCharSequence);
    }
    AppMethodBeat.o(23833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */