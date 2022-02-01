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
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference
  extends Preference
{
  private CharSequence Kp;
  private String mDeviceName;
  protected MMActivity nCW;
  private String oyz;
  private View.OnClickListener[] paA;
  private String paB;
  private boolean paC;
  private ImageView pat;
  private TextView pau;
  private TextView pav;
  private TextView paw;
  private View pax;
  private TextView pay;
  private boolean[] paz;
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23827);
    this.paz = new boolean[6];
    this.paA = new View.OnClickListener[6];
    this.paC = false;
    this.nCW = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(23827);
  }
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23828);
    this.paz = new boolean[6];
    this.paA = new View.OnClickListener[6];
    this.paC = false;
    this.nCW = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(23828);
  }
  
  private void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(23830);
    if (this.paz[paramInt] != 0) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      paramView.setOnClickListener(this.paA[paramInt]);
      AppMethodBeat.o(23830);
      return;
    }
  }
  
  public final void UU(String paramString)
  {
    AppMethodBeat.i(23834);
    this.mDeviceName = paramString;
    if (this.paw != null) {
      this.paw.setText(paramString);
    }
    AppMethodBeat.o(23834);
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
      localObject = this.pat;
    }
    for (;;)
    {
      this.paA[paramInt] = paramOnClickListener;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(paramOnClickListener);
      }
      AppMethodBeat.o(23832);
      return;
      localObject = this.pau;
      continue;
      localObject = this.pav;
      continue;
      localObject = this.paw;
      continue;
      localObject = this.pax;
      continue;
      localObject = this.pay;
    }
  }
  
  public final void aa(int paramInt, boolean paramBoolean)
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
      localObject = this.pat;
      boolean[] arrayOfBoolean = this.paz;
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
      localObject = this.pau;
      break;
      localObject = this.pav;
      break;
      localObject = this.paw;
      break;
      localObject = this.pax;
      break;
      localObject = this.pay;
      break;
      j = 0;
      break label74;
    }
  }
  
  public final void nP(String paramString)
  {
    AppMethodBeat.i(23836);
    this.oyz = paramString;
    if (this.pat != null)
    {
      c.a locala = new c.a();
      Bitmap localBitmap = f.Wf(2131232108);
      paramString = localBitmap;
      if (localBitmap != null)
      {
        paramString = localBitmap;
        if (!localBitmap.isRecycled())
        {
          localBitmap = f.a(localBitmap, true, 0.5F * localBitmap.getWidth());
          paramString = localBitmap;
          if (localBitmap != null)
          {
            paramString = localBitmap;
            if (!localBitmap.isRecycled())
            {
              locala.gjy = new BitmapDrawable(localBitmap);
              paramString = localBitmap;
            }
          }
        }
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        locala.hkf = 2131232108;
      }
      locala.gkG = true;
      paramString = locala.azc();
      o.ayJ().a(this.oyz, this.pat, paramString);
    }
    AppMethodBeat.o(23836);
  }
  
  public final void nS(String paramString)
  {
    AppMethodBeat.i(23835);
    this.paB = paramString;
    if (this.pay != null) {
      this.pay.setText(paramString);
    }
    AppMethodBeat.o(23835);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23829);
    ad.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
    this.pat = ((ImageView)paramView.findViewById(2131296997));
    this.pau = ((TextView)paramView.findViewById(2131302656));
    this.pav = ((TextView)paramView.findViewById(2131299249));
    this.paw = ((TextView)paramView.findViewById(2131299068));
    this.pax = paramView.findViewById(2131299250);
    this.pay = ((TextView)paramView.findViewById(2131299067));
    Z(this.pat, 0);
    Z(this.pau, 2);
    Z(this.pav, 1);
    Z(this.paw, 3);
    Z(this.pax, 4);
    Z(this.pay, 5);
    this.paC = true;
    if (!this.paC) {
      ad.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.paC);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(23829);
      return;
      this.pau.setText(this.Kp);
      this.paw.setText(this.mDeviceName);
      this.pay.setText(this.paB);
      nP(this.oyz);
    }
  }
  
  public final void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(23833);
    this.Kp = paramCharSequence;
    if (this.pau != null) {
      this.pau.setText(paramCharSequence);
    }
    AppMethodBeat.o(23833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */