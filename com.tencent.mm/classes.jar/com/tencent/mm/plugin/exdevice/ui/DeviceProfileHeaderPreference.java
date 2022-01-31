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
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference
  extends Preference
{
  private CharSequence Dy;
  protected MMActivity kxD;
  private ImageView lJJ;
  private TextView lJK;
  private TextView lJL;
  private TextView lJM;
  private View lJN;
  private TextView lJO;
  private boolean[] lJP;
  private View.OnClickListener[] lJQ;
  private String lJR;
  private boolean lJS;
  private String lix;
  private String mDeviceName;
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(19759);
    this.lJP = new boolean[6];
    this.lJQ = new View.OnClickListener[6];
    this.lJS = false;
    this.kxD = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(19759);
  }
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(19760);
    this.lJP = new boolean[6];
    this.lJQ = new View.OnClickListener[6];
    this.lJS = false;
    this.kxD = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(19760);
  }
  
  private void X(View paramView, int paramInt)
  {
    AppMethodBeat.i(19762);
    if (this.lJP[paramInt] != 0) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      paramView.setOnClickListener(this.lJQ[paramInt]);
      AppMethodBeat.o(19762);
      return;
    }
  }
  
  public final void LL(String paramString)
  {
    AppMethodBeat.i(19766);
    this.mDeviceName = paramString;
    if (this.lJM != null) {
      this.lJM.setText(paramString);
    }
    AppMethodBeat.o(19766);
  }
  
  public final void S(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(19763);
    Object localObject;
    int j;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(19763);
      return;
    case 0: 
      localObject = this.lJJ;
      boolean[] arrayOfBoolean = this.lJP;
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
      AppMethodBeat.o(19763);
      return;
      localObject = this.lJK;
      break;
      localObject = this.lJL;
      break;
      localObject = this.lJM;
      break;
      localObject = this.lJN;
      break;
      localObject = this.lJO;
      break;
      j = 0;
      break label74;
    }
  }
  
  public final void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(19764);
    Object localObject;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(19764);
      return;
    case 0: 
      localObject = this.lJJ;
    }
    for (;;)
    {
      this.lJQ[paramInt] = paramOnClickListener;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(paramOnClickListener);
      }
      AppMethodBeat.o(19764);
      return;
      localObject = this.lJK;
      continue;
      localObject = this.lJL;
      continue;
      localObject = this.lJM;
      continue;
      localObject = this.lJN;
      continue;
      localObject = this.lJO;
    }
  }
  
  public final void ka(String paramString)
  {
    AppMethodBeat.i(19768);
    this.lix = paramString;
    if (this.lJJ != null)
    {
      c.a locala = new c.a();
      Bitmap localBitmap = d.Na(2130838667);
      paramString = localBitmap;
      if (localBitmap != null)
      {
        paramString = localBitmap;
        if (!localBitmap.isRecycled())
        {
          localBitmap = d.a(localBitmap, true, 0.5F * localBitmap.getWidth());
          paramString = localBitmap;
          if (localBitmap != null)
          {
            paramString = localBitmap;
            if (!localBitmap.isRecycled())
            {
              locala.eNZ = new BitmapDrawable(localBitmap);
              paramString = localBitmap;
            }
          }
        }
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        locala.eNY = 2130838667;
      }
      locala.eOk = true;
      paramString = locala.ahY();
      o.ahG().a(this.lix, this.lJJ, paramString);
    }
    AppMethodBeat.o(19768);
  }
  
  public final void kd(String paramString)
  {
    AppMethodBeat.i(19767);
    this.lJR = paramString;
    if (this.lJO != null) {
      this.lJO.setText(paramString);
    }
    AppMethodBeat.o(19767);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(19761);
    ab.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
    this.lJJ = ((ImageView)paramView.findViewById(2131823768));
    this.lJK = ((TextView)paramView.findViewById(2131823741));
    this.lJL = ((TextView)paramView.findViewById(2131823770));
    this.lJM = ((TextView)paramView.findViewById(2131823771));
    this.lJN = paramView.findViewById(2131823769);
    this.lJO = ((TextView)paramView.findViewById(2131823772));
    X(this.lJJ, 0);
    X(this.lJK, 2);
    X(this.lJL, 1);
    X(this.lJM, 3);
    X(this.lJN, 4);
    X(this.lJO, 5);
    this.lJS = true;
    if (!this.lJS) {
      ab.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.lJS);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(19761);
      return;
      this.lJK.setText(this.Dy);
      this.lJM.setText(this.mDeviceName);
      this.lJO.setText(this.lJR);
      ka(this.lix);
    }
  }
  
  public final void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(19765);
    this.Dy = paramCharSequence;
    if (this.lJK != null) {
      this.lJK.setText(paramCharSequence);
    }
    AppMethodBeat.o(19765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */