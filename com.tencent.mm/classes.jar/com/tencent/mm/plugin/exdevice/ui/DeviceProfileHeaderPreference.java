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
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference
  extends Preference
{
  private CharSequence ec;
  private String mDeviceName;
  protected MMActivity tzD;
  private String uFL;
  private ImageView vkF;
  private TextView vkG;
  private TextView vkH;
  private TextView vkI;
  private View vkJ;
  private TextView vkK;
  private boolean[] vkL;
  private View.OnClickListener[] vkM;
  private String vkN;
  private boolean vkO;
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23827);
    this.vkL = new boolean[6];
    this.vkM = new View.OnClickListener[6];
    this.vkO = false;
    this.tzD = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(23827);
  }
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23828);
    this.vkL = new boolean[6];
    this.vkM = new View.OnClickListener[6];
    this.vkO = false;
    this.tzD = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(23828);
  }
  
  private void ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(23830);
    if (this.vkL[paramInt] != 0) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      paramView.setOnClickListener(this.vkM[paramInt]);
      AppMethodBeat.o(23830);
      return;
    }
  }
  
  public final void Jg(String paramString)
  {
    AppMethodBeat.i(23835);
    this.vkN = paramString;
    if (this.vkK != null) {
      this.vkK.setText(paramString);
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
      localObject = this.vkF;
    }
    for (;;)
    {
      this.vkM[paramInt] = paramOnClickListener;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(paramOnClickListener);
      }
      AppMethodBeat.o(23832);
      return;
      localObject = this.vkG;
      continue;
      localObject = this.vkH;
      continue;
      localObject = this.vkI;
      continue;
      localObject = this.vkJ;
      continue;
      localObject = this.vkK;
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
      localObject = this.vkF;
      boolean[] arrayOfBoolean = this.vkL;
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
      localObject = this.vkG;
      break;
      localObject = this.vkH;
      break;
      localObject = this.vkI;
      break;
      localObject = this.vkJ;
      break;
      localObject = this.vkK;
      break;
      j = 0;
      break label74;
    }
  }
  
  public final void avL(String paramString)
  {
    AppMethodBeat.i(23834);
    this.mDeviceName = paramString;
    if (this.vkI != null) {
      this.vkI.setText(paramString);
    }
    AppMethodBeat.o(23834);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23829);
    Log.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
    this.vkF = ((ImageView)paramView.findViewById(R.h.dsd));
    this.vkG = ((TextView)paramView.findViewById(R.h.dNd));
    this.vkH = ((TextView)paramView.findViewById(R.h.dFp));
    this.vkI = ((TextView)paramView.findViewById(R.h.dEj));
    this.vkJ = paramView.findViewById(R.h.dFq);
    this.vkK = ((TextView)paramView.findViewById(R.h.dEi));
    ac(this.vkF, 0);
    ac(this.vkG, 2);
    ac(this.vkH, 1);
    ac(this.vkI, 3);
    ac(this.vkJ, 4);
    ac(this.vkK, 5);
    this.vkO = true;
    if (!this.vkO) {
      Log.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.vkO);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(23829);
      return;
      this.vkG.setText(this.ec);
      this.vkI.setText(this.mDeviceName);
      this.vkK.setText(this.vkN);
      setIconUrl(this.uFL);
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(23836);
    this.uFL = paramString;
    if (this.vkF != null)
    {
      c.a locala = new c.a();
      Bitmap localBitmap = BitmapUtil.getBitmapNative(R.g.dnt);
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
              locala.kOi = new BitmapDrawable(localBitmap);
              paramString = localBitmap;
            }
          }
        }
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        locala.lRP = R.g.dnt;
      }
      locala.kPz = true;
      paramString = locala.bmL();
      q.bml().a(this.uFL, this.vkF, paramString);
    }
    AppMethodBeat.o(23836);
  }
  
  public final void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(23833);
    this.ec = paramCharSequence;
    if (this.vkG != null) {
      this.vkG.setText(paramCharSequence);
    }
    AppMethodBeat.o(23833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */