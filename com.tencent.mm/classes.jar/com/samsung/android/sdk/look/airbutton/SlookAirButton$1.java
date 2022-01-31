package com.samsung.android.sdk.look.airbutton;

import android.view.View;
import com.samsung.android.airbutton.AirButtonImpl.OnItemSelectedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SlookAirButton$1
  implements AirButtonImpl.OnItemSelectedListener
{
  SlookAirButton$1(SlookAirButton paramSlookAirButton) {}
  
  public void onItemSelected(View paramView, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(117271);
    SlookAirButton.access$000(this.this$0).onItemSelected(paramView, paramInt, paramObject);
    AppMethodBeat.o(117271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButton.1
 * JD-Core Version:    0.7.0.1
 */