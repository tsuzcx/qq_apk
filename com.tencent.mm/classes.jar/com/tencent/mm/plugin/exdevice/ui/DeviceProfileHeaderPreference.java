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
import com.tencent.mm.av.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference
  extends Preference
{
  private CharSequence Lk;
  private String mDeviceName;
  protected MMActivity ofX;
  private ImageView pDE;
  private TextView pDF;
  private TextView pDG;
  private TextView pDH;
  private View pDI;
  private TextView pDJ;
  private boolean[] pDK;
  private View.OnClickListener[] pDL;
  private String pDM;
  private boolean pDN;
  private String pbZ;
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23827);
    this.pDK = new boolean[6];
    this.pDL = new View.OnClickListener[6];
    this.pDN = false;
    this.ofX = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(23827);
  }
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23828);
    this.pDK = new boolean[6];
    this.pDL = new View.OnClickListener[6];
    this.pDN = false;
    this.ofX = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(23828);
  }
  
  private void aa(View paramView, int paramInt)
  {
    AppMethodBeat.i(23830);
    if (this.pDK[paramInt] != 0) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      paramView.setOnClickListener(this.pDL[paramInt]);
      AppMethodBeat.o(23830);
      return;
    }
  }
  
  public final void Zg(String paramString)
  {
    AppMethodBeat.i(23834);
    this.mDeviceName = paramString;
    if (this.pDH != null) {
      this.pDH.setText(paramString);
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
      localObject = this.pDE;
    }
    for (;;)
    {
      this.pDL[paramInt] = paramOnClickListener;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(paramOnClickListener);
      }
      AppMethodBeat.o(23832);
      return;
      localObject = this.pDF;
      continue;
      localObject = this.pDG;
      continue;
      localObject = this.pDH;
      continue;
      localObject = this.pDI;
      continue;
      localObject = this.pDJ;
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
      localObject = this.pDE;
      boolean[] arrayOfBoolean = this.pDK;
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
      localObject = this.pDF;
      break;
      localObject = this.pDG;
      break;
      localObject = this.pDH;
      break;
      localObject = this.pDI;
      break;
      localObject = this.pDJ;
      break;
      j = 0;
      break label74;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23829);
    ac.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
    this.pDE = ((ImageView)paramView.findViewById(2131296997));
    this.pDF = ((TextView)paramView.findViewById(2131302656));
    this.pDG = ((TextView)paramView.findViewById(2131299249));
    this.pDH = ((TextView)paramView.findViewById(2131299068));
    this.pDI = paramView.findViewById(2131299250);
    this.pDJ = ((TextView)paramView.findViewById(2131299067));
    aa(this.pDE, 0);
    aa(this.pDF, 2);
    aa(this.pDG, 1);
    aa(this.pDH, 3);
    aa(this.pDI, 4);
    aa(this.pDJ, 5);
    this.pDN = true;
    if (!this.pDN) {
      ac.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.pDN);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(23829);
      return;
      this.pDF.setText(this.Lk);
      this.pDH.setText(this.mDeviceName);
      this.pDJ.setText(this.pDM);
      qV(this.pbZ);
    }
  }
  
  public final void qV(String paramString)
  {
    AppMethodBeat.i(23836);
    this.pbZ = paramString;
    if (this.pDE != null)
    {
      c.a locala = new c.a();
      Bitmap localBitmap = f.Yo(2131232108);
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
              locala.gKj = new BitmapDrawable(localBitmap);
              paramString = localBitmap;
            }
          }
        }
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        locala.hKI = 2131232108;
      }
      locala.gLt = true;
      paramString = locala.aFT();
      o.aFB().a(this.pbZ, this.pDE, paramString);
    }
    AppMethodBeat.o(23836);
  }
  
  public final void qY(String paramString)
  {
    AppMethodBeat.i(23835);
    this.pDM = paramString;
    if (this.pDJ != null) {
      this.pDJ.setText(paramString);
    }
    AppMethodBeat.o(23835);
  }
  
  public final void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(23833);
    this.Lk = paramCharSequence;
    if (this.pDF != null) {
      this.pDF.setText(paramCharSequence);
    }
    AppMethodBeat.o(23833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */