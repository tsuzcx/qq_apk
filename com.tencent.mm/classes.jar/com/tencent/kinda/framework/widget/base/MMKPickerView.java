package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.KPickerView;
import com.tencent.kinda.gen.VoidListCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class MMKPickerView
  extends MMKView<KindaPickerViewImpl<String>>
  implements KPickerView
{
  public KindaPickerViewImpl createView(Context paramContext)
  {
    AppMethodBeat.i(199511);
    this.view = new KindaPickerViewImpl(paramContext);
    paramContext = (KindaPickerViewImpl)this.view;
    AppMethodBeat.o(199511);
    return paramContext;
  }
  
  public ArrayList<Integer> getCurrentSelectedRows()
  {
    AppMethodBeat.i(199515);
    ArrayList localArrayList = ((KindaPickerViewImpl)this.view).getCurrentItems();
    AppMethodBeat.o(199515);
    return localArrayList;
  }
  
  public void setCallbackImpl(final VoidListCallback paramVoidListCallback)
  {
    AppMethodBeat.i(199514);
    ((KindaPickerViewImpl)this.view).setOnSelectChangeListener(new KindaPickerViewImpl.OnSelectChangeListener()
    {
      public void onSelected(ArrayList<Integer> paramAnonymousArrayList)
      {
        AppMethodBeat.i(199510);
        if (paramVoidListCallback != null) {
          paramVoidListCallback.call(paramAnonymousArrayList);
        }
        AppMethodBeat.o(199510);
      }
    });
    AppMethodBeat.o(199514);
  }
  
  public void setNormalData(ArrayList<ArrayList<String>> paramArrayList)
  {
    AppMethodBeat.i(199512);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(199512);
      return;
    }
    ((KindaPickerViewImpl)this.view).setIndividualPicker(paramArrayList);
    AppMethodBeat.o(199512);
  }
  
  public void setSelectedRows(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(199516);
    ((KindaPickerViewImpl)this.view).setCurrentItems(paramArrayList);
    AppMethodBeat.o(199516);
  }
  
  public void setSyncData(ArrayList<String> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1)
  {
    AppMethodBeat.i(199513);
    ((KindaPickerViewImpl)this.view).setLinkagePicker(paramArrayList, paramArrayList1);
    AppMethodBeat.o(199513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKPickerView
 * JD-Core Version:    0.7.0.1
 */