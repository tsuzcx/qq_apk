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
    AppMethodBeat.i(193227);
    this.view = new KindaPickerViewImpl(paramContext);
    paramContext = (KindaPickerViewImpl)this.view;
    AppMethodBeat.o(193227);
    return paramContext;
  }
  
  public ArrayList<Integer> getCurrentSelectedRows()
  {
    AppMethodBeat.i(193231);
    ArrayList localArrayList = ((KindaPickerViewImpl)this.view).getCurrentItems();
    AppMethodBeat.o(193231);
    return localArrayList;
  }
  
  public void setCallbackImpl(final VoidListCallback paramVoidListCallback)
  {
    AppMethodBeat.i(193230);
    ((KindaPickerViewImpl)this.view).setOnSelectChangeListener(new KindaPickerViewImpl.OnSelectChangeListener()
    {
      public void onSelected(ArrayList<Integer> paramAnonymousArrayList)
      {
        AppMethodBeat.i(193226);
        if (paramVoidListCallback != null) {
          paramVoidListCallback.call(paramAnonymousArrayList);
        }
        AppMethodBeat.o(193226);
      }
    });
    AppMethodBeat.o(193230);
  }
  
  public void setNormalData(ArrayList<ArrayList<String>> paramArrayList)
  {
    AppMethodBeat.i(193228);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(193228);
      return;
    }
    ((KindaPickerViewImpl)this.view).setIndividualPicker(paramArrayList);
    AppMethodBeat.o(193228);
  }
  
  public void setSelectedRows(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(193232);
    ((KindaPickerViewImpl)this.view).setCurrentItems(paramArrayList);
    AppMethodBeat.o(193232);
  }
  
  public void setSyncData(ArrayList<String> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1)
  {
    AppMethodBeat.i(193229);
    ((KindaPickerViewImpl)this.view).setLinkagePicker(paramArrayList, paramArrayList1);
    AppMethodBeat.o(193229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKPickerView
 * JD-Core Version:    0.7.0.1
 */