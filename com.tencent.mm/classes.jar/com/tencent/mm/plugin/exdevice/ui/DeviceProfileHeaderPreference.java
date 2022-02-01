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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference
  extends Preference
{
  private CharSequence Nc;
  private String mDeviceName;
  protected MMActivity oPS;
  private String pMn;
  private ImageView qnO;
  private TextView qnP;
  private TextView qnQ;
  private TextView qnR;
  private View qnS;
  private TextView qnT;
  private boolean[] qnU;
  private View.OnClickListener[] qnV;
  private String qnW;
  private boolean qnX;
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23827);
    this.qnU = new boolean[6];
    this.qnV = new View.OnClickListener[6];
    this.qnX = false;
    this.oPS = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(23827);
  }
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23828);
    this.qnU = new boolean[6];
    this.qnV = new View.OnClickListener[6];
    this.qnX = false;
    this.oPS = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(23828);
  }
  
  private void ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(23830);
    if (this.qnU[paramInt] != 0) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      paramView.setOnClickListener(this.qnV[paramInt]);
      AppMethodBeat.o(23830);
      return;
    }
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
      localObject = this.qnO;
    }
    for (;;)
    {
      this.qnV[paramInt] = paramOnClickListener;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(paramOnClickListener);
      }
      AppMethodBeat.o(23832);
      return;
      localObject = this.qnP;
      continue;
      localObject = this.qnQ;
      continue;
      localObject = this.qnR;
      continue;
      localObject = this.qnS;
      continue;
      localObject = this.qnT;
    }
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
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
      localObject = this.qnO;
      boolean[] arrayOfBoolean = this.qnU;
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
      localObject = this.qnP;
      break;
      localObject = this.qnQ;
      break;
      localObject = this.qnR;
      break;
      localObject = this.qnS;
      break;
      localObject = this.qnT;
      break;
      j = 0;
      break label74;
    }
  }
  
  public final void adD(String paramString)
  {
    AppMethodBeat.i(23834);
    this.mDeviceName = paramString;
    if (this.qnR != null) {
      this.qnR.setText(paramString);
    }
    AppMethodBeat.o(23834);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23829);
    ae.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
    this.qnO = ((ImageView)paramView.findViewById(2131296997));
    this.qnP = ((TextView)paramView.findViewById(2131302656));
    this.qnQ = ((TextView)paramView.findViewById(2131299249));
    this.qnR = ((TextView)paramView.findViewById(2131299068));
    this.qnS = paramView.findViewById(2131299250);
    this.qnT = ((TextView)paramView.findViewById(2131299067));
    ab(this.qnO, 0);
    ab(this.qnP, 2);
    ab(this.qnQ, 1);
    ab(this.qnR, 3);
    ab(this.qnS, 4);
    ab(this.qnT, 5);
    this.qnX = true;
    if (!this.qnX) {
      ae.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.qnX);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(23829);
      return;
      this.qnP.setText(this.Nc);
      this.qnR.setText(this.mDeviceName);
      this.qnT.setText(this.qnW);
      setIconUrl(this.pMn);
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(23836);
    this.pMn = paramString;
    if (this.qnO != null)
    {
      c.a locala = new c.a();
      Bitmap localBitmap = h.aaZ(2131232108);
      paramString = localBitmap;
      if (localBitmap != null)
      {
        paramString = localBitmap;
        if (!localBitmap.isRecycled())
        {
          localBitmap = h.a(localBitmap, true, 0.5F * localBitmap.getWidth());
          paramString = localBitmap;
          if (localBitmap != null)
          {
            paramString = localBitmap;
            if (!localBitmap.isRecycled())
            {
              locala.hgI = new BitmapDrawable(localBitmap);
              paramString = localBitmap;
            }
          }
        }
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        locala.igv = 2131232108;
      }
      locala.hhW = true;
      paramString = locala.aJu();
      q.aJb().a(this.pMn, this.qnO, paramString);
    }
    AppMethodBeat.o(23836);
  }
  
  public final void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(23833);
    this.Nc = paramCharSequence;
    if (this.qnP != null) {
      this.qnP.setText(paramCharSequence);
    }
    AppMethodBeat.o(23833);
  }
  
  public final void uc(String paramString)
  {
    AppMethodBeat.i(23835);
    this.qnW = paramString;
    if (this.qnT != null) {
      this.qnT.setText(paramString);
    }
    AppMethodBeat.o(23835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */