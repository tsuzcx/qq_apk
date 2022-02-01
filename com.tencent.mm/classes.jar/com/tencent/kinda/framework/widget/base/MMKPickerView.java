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
    AppMethodBeat.i(214540);
    this.view = new KindaPickerViewImpl(paramContext);
    paramContext = (KindaPickerViewImpl)this.view;
    AppMethodBeat.o(214540);
    return paramContext;
  }
  
  public ArrayList<Integer> getCurrentSelectedRows()
  {
    AppMethodBeat.i(214544);
    ArrayList localArrayList = ((KindaPickerViewImpl)this.view).getCurrentItems();
    AppMethodBeat.o(214544);
    return localArrayList;
  }
  
  public void setCallbackImpl(final VoidListCallback paramVoidListCallback)
  {
    AppMethodBeat.i(214543);
    ((KindaPickerViewImpl)this.view).setOnSelectChangeListener(new KindaPickerViewImpl.OnSelectChangeListener()
    {
      public void onSelected(ArrayList<Integer> paramAnonymousArrayList)
      {
        AppMethodBeat.i(214539);
        if (paramVoidListCallback != null) {
          paramVoidListCallback.call(paramAnonymousArrayList);
        }
        AppMethodBeat.o(214539);
      }
    });
    AppMethodBeat.o(214543);
  }
  
  public void setNormalData(ArrayList<ArrayList<String>> paramArrayList)
  {
    AppMethodBeat.i(214541);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(214541);
      return;
    }
    ((KindaPickerViewImpl)this.view).setIndividualPicker(paramArrayList);
    AppMethodBeat.o(214541);
  }
  
  public void setSelectedRows(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(214545);
    ((KindaPickerViewImpl)this.view).setCurrentItems(paramArrayList);
    AppMethodBeat.o(214545);
  }
  
  public void setSyncData(ArrayList<String> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1)
  {
    AppMethodBeat.i(214542);
    ((KindaPickerViewImpl)this.view).setLinkagePicker(paramArrayList, paramArrayList1);
    AppMethodBeat.o(214542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKPickerView
 * JD-Core Version:    0.7.0.1
 */