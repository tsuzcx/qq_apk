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
import com.tencent.mm.aw.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference
  extends Preference
{
  private CharSequence Nc;
  private String mDeviceName;
  protected MMActivity oJq;
  private String pFJ;
  private ImageView qhj;
  private TextView qhk;
  private TextView qhl;
  private TextView qhm;
  private View qhn;
  private TextView qho;
  private boolean[] qhp;
  private View.OnClickListener[] qhq;
  private String qhr;
  private boolean qhs;
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23827);
    this.qhp = new boolean[6];
    this.qhq = new View.OnClickListener[6];
    this.qhs = false;
    this.oJq = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(23827);
  }
  
  public DeviceProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23828);
    this.qhp = new boolean[6];
    this.qhq = new View.OnClickListener[6];
    this.qhs = false;
    this.oJq = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(23828);
  }
  
  private void ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(23830);
    if (this.qhp[paramInt] != 0) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      paramView.setOnClickListener(this.qhq[paramInt]);
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
      localObject = this.qhj;
    }
    for (;;)
    {
      this.qhq[paramInt] = paramOnClickListener;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(paramOnClickListener);
      }
      AppMethodBeat.o(23832);
      return;
      localObject = this.qhk;
      continue;
      localObject = this.qhl;
      continue;
      localObject = this.qhm;
      continue;
      localObject = this.qhn;
      continue;
      localObject = this.qho;
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
      localObject = this.qhj;
      boolean[] arrayOfBoolean = this.qhp;
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
      localObject = this.qhk;
      break;
      localObject = this.qhl;
      break;
      localObject = this.qhm;
      break;
      localObject = this.qhn;
      break;
      localObject = this.qho;
      break;
      j = 0;
      break label74;
    }
  }
  
  public final void acM(String paramString)
  {
    AppMethodBeat.i(23834);
    this.mDeviceName = paramString;
    if (this.qhm != null) {
      this.qhm.setText(paramString);
    }
    AppMethodBeat.o(23834);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23829);
    ad.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
    this.qhj = ((ImageView)paramView.findViewById(2131296997));
    this.qhk = ((TextView)paramView.findViewById(2131302656));
    this.qhl = ((TextView)paramView.findViewById(2131299249));
    this.qhm = ((TextView)paramView.findViewById(2131299068));
    this.qhn = paramView.findViewById(2131299250);
    this.qho = ((TextView)paramView.findViewById(2131299067));
    ab(this.qhj, 0);
    ab(this.qhk, 2);
    ab(this.qhl, 1);
    ab(this.qhm, 3);
    ab(this.qhn, 4);
    ab(this.qho, 5);
    this.qhs = true;
    if (!this.qhs) {
      ad.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.qhs);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(23829);
      return;
      this.qhk.setText(this.Nc);
      this.qhm.setText(this.mDeviceName);
      this.qho.setText(this.qhr);
      setIconUrl(this.pFJ);
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(23836);
    this.pFJ = paramString;
    if (this.qhj != null)
    {
      c.a locala = new c.a();
      Bitmap localBitmap = g.aat(2131232108);
      paramString = localBitmap;
      if (localBitmap != null)
      {
        paramString = localBitmap;
        if (!localBitmap.isRecycled())
        {
          localBitmap = g.a(localBitmap, true, 0.5F * localBitmap.getWidth());
          paramString = localBitmap;
          if (localBitmap != null)
          {
            paramString = localBitmap;
            if (!localBitmap.isRecycled())
            {
              locala.hdU = new BitmapDrawable(localBitmap);
              paramString = localBitmap;
            }
          }
        }
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        locala.idD = 2131232108;
      }
      locala.hfi = true;
      paramString = locala.aJc();
      q.aIJ().a(this.pFJ, this.qhj, paramString);
    }
    AppMethodBeat.o(23836);
  }
  
  public final void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(23833);
    this.Nc = paramCharSequence;
    if (this.qhk != null) {
      this.qhk.setText(paramCharSequence);
    }
    AppMethodBeat.o(23833);
  }
  
  public final void tH(String paramString)
  {
    AppMethodBeat.i(23835);
    this.qhr = paramString;
    if (this.qho != null) {
      this.qho.setText(paramString);
    }
    AppMethodBeat.o(23835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */