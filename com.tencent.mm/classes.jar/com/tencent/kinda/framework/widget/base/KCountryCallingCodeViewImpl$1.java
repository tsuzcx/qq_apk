package com.tencent.kinda.framework.widget.base;

import android.content.Intent;
import com.tencent.kinda.framework.app.UIPageFragmentActivity.IntentHandler;
import com.tencent.kinda.gen.KCountryCallingCodeViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KCountryCallingCodeViewImpl$1
  implements UIPageFragmentActivity.IntentHandler
{
  KCountryCallingCodeViewImpl$1(KCountryCallingCodeViewImpl paramKCountryCallingCodeViewImpl) {}
  
  public void handle(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(144675);
    KCountryCallingCodeViewImpl.access$002(this.this$0, paramIntent.getStringExtra("country_name"));
    KCountryCallingCodeViewImpl.access$102(this.this$0, paramIntent.getStringExtra("couttry_code"));
    KCountryCallingCodeViewImpl.access$202(this.this$0, paramIntent.getStringExtra("iso_code"));
    KCountryCallingCodeViewImpl.access$300(this.this$0);
    KCountryCallingCodeViewImpl.access$400(this.this$0).onSelect(KCountryCallingCodeViewImpl.access$100(this.this$0), KCountryCallingCodeViewImpl.access$200(this.this$0));
    AppMethodBeat.o(144675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KCountryCallingCodeViewImpl.1
 * JD-Core Version:    0.7.0.1
 */