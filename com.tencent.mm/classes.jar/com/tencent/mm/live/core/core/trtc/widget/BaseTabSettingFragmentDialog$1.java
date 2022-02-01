package com.tencent.mm.live.core.core.trtc.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class BaseTabSettingFragmentDialog$1
  extends i
{
  BaseTabSettingFragmentDialog$1(BaseTabSettingFragmentDialog paramBaseTabSettingFragmentDialog, g paramg)
  {
    super(paramg);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(196304);
    if (BaseTabSettingFragmentDialog.a(this.hCb) == null)
    {
      AppMethodBeat.o(196304);
      return 0;
    }
    int i = BaseTabSettingFragmentDialog.a(this.hCb).size();
    AppMethodBeat.o(196304);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(196303);
    if (BaseTabSettingFragmentDialog.a(this.hCb) == null)
    {
      AppMethodBeat.o(196303);
      return null;
    }
    Fragment localFragment = (Fragment)BaseTabSettingFragmentDialog.a(this.hCb).get(paramInt);
    AppMethodBeat.o(196303);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.BaseTabSettingFragmentDialog.1
 * JD-Core Version:    0.7.0.1
 */