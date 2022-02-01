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
    AppMethodBeat.i(226511);
    this.view = new KindaPickerViewImpl(paramContext);
    paramContext = (KindaPickerViewImpl)this.view;
    AppMethodBeat.o(226511);
    return paramContext;
  }
  
  public ArrayList<Integer> getCurrentSelectedRows()
  {
    AppMethodBeat.i(226526);
    ArrayList localArrayList = ((KindaPickerViewImpl)this.view).getCurrentItems();
    AppMethodBeat.o(226526);
    return localArrayList;
  }
  
  public void setCallbackImpl(final VoidListCallback paramVoidListCallback)
  {
    AppMethodBeat.i(226522);
    ((KindaPickerViewImpl)this.view).setOnSelectChangeListener(new KindaPickerViewImpl.OnSelectChangeListener()
    {
      public void onSelected(ArrayList<Integer> paramAnonymousArrayList)
      {
        AppMethodBeat.i(226506);
        if (paramVoidListCallback != null) {
          paramVoidListCallback.call(paramAnonymousArrayList);
        }
        AppMethodBeat.o(226506);
      }
    });
    AppMethodBeat.o(226522);
  }
  
  public void setNormalData(ArrayList<ArrayList<String>> paramArrayList)
  {
    AppMethodBeat.i(226515);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(226515);
      return;
    }
    ((KindaPickerViewImpl)this.view).setIndividualPicker(paramArrayList);
    AppMethodBeat.o(226515);
  }
  
  public void setSelectedRows(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(226528);
    ((KindaPickerViewImpl)this.view).setCurrentItems(paramArrayList);
    AppMethodBeat.o(226528);
  }
  
  public void setSyncData(ArrayList<String> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1)
  {
    AppMethodBeat.i(226518);
    ((KindaPickerViewImpl)this.view).setLinkagePicker(paramArrayList, paramArrayList1);
    AppMethodBeat.o(226518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKPickerView
 * JD-Core Version:    0.7.0.1
 */