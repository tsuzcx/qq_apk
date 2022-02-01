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
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference
  extends Preference
{
  private CharSequence Nm;
  private String mDeviceName;
  protected MMActivity qdG;
  private ImageView rEV;
  private TextView rEW;
  private TextView rEX;
  private TextView rEY;
  private View rEZ;
  private TextView rFa;
  private boolean[] rFb;
  private View.OnClickListener[] rFc;
  private String rFd;
  private boolean rFe;
  private String rcG;
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23827);
    this.rFb = new boolean[6];
    this.rFc = new View.OnClickListener[6];
    this.rFe = false;
    this.qdG = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(23827);
  }
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23828);
    this.rFb = new boolean[6];
    this.rFc = new View.OnClickListener[6];
    this.rFe = false;
    this.qdG = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(23828);
  }
  
  private void aa(View paramView, int paramInt)
  {
    AppMethodBeat.i(23830);
    if (this.rFb[paramInt] != 0) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      paramView.setOnClickListener(this.rFc[paramInt]);
      AppMethodBeat.o(23830);
      return;
    }
  }
  
  public final void Cs(String paramString)
  {
    AppMethodBeat.i(23835);
    this.rFd = paramString;
    if (this.rFa != null) {
      this.rFa.setText(paramString);
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
      localObject = this.rEV;
    }
    for (;;)
    {
      this.rFc[paramInt] = paramOnClickListener;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(paramOnClickListener);
      }
      AppMethodBeat.o(23832);
      return;
      localObject = this.rEW;
      continue;
      localObject = this.rEX;
      continue;
      localObject = this.rEY;
      continue;
      localObject = this.rEZ;
      continue;
      localObject = this.rFa;
    }
  }
  
  public final void ai(int paramInt, boolean paramBoolean)
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
      localObject = this.rEV;
      boolean[] arrayOfBoolean = this.rFb;
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
      localObject = this.rEW;
      break;
      localObject = this.rEX;
      break;
      localObject = this.rEY;
      break;
      localObject = this.rEZ;
      break;
      localObject = this.rFa;
      break;
      j = 0;
      break label74;
    }
  }
  
  public final void anM(String paramString)
  {
    AppMethodBeat.i(23834);
    this.mDeviceName = paramString;
    if (this.rEY != null) {
      this.rEY.setText(paramString);
    }
    AppMethodBeat.o(23834);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23829);
    Log.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
    this.rEV = ((ImageView)paramView.findViewById(2131297120));
    this.rEW = ((TextView)paramView.findViewById(2131305210));
    this.rEX = ((TextView)paramView.findViewById(2131299821));
    this.rEY = ((TextView)paramView.findViewById(2131299574));
    this.rEZ = paramView.findViewById(2131299822);
    this.rFa = ((TextView)paramView.findViewById(2131299573));
    aa(this.rEV, 0);
    aa(this.rEW, 2);
    aa(this.rEX, 1);
    aa(this.rEY, 3);
    aa(this.rEZ, 4);
    aa(this.rFa, 5);
    this.rFe = true;
    if (!this.rFe) {
      Log.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.rFe);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(23829);
      return;
      this.rEW.setText(this.Nm);
      this.rEY.setText(this.mDeviceName);
      this.rFa.setText(this.rFd);
      setIconUrl(this.rcG);
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(23836);
    this.rcG = paramString;
    if (this.rEV != null)
    {
      c.a locala = new c.a();
      Bitmap localBitmap = BitmapUtil.getBitmapNative(2131232204);
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
              locala.hZC = new BitmapDrawable(localBitmap);
              paramString = localBitmap;
            }
          }
        }
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        locala.jbq = 2131232204;
      }
      locala.iaT = true;
      paramString = locala.bdv();
      q.bcV().a(this.rcG, this.rEV, paramString);
    }
    AppMethodBeat.o(23836);
  }
  
  public final void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(23833);
    this.Nm = paramCharSequence;
    if (this.rEW != null) {
      this.rEW.setText(paramCharSequence);
    }
    AppMethodBeat.o(23833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */