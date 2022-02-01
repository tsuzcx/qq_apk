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
    AppMethodBeat.i(264387);
    this.view = new KindaPickerViewImpl(paramContext);
    paramContext = (KindaPickerViewImpl)this.view;
    AppMethodBeat.o(264387);
    return paramContext;
  }
  
  public ArrayList<Integer> getCurrentSelectedRows()
  {
    AppMethodBeat.i(264395);
    ArrayList localArrayList = ((KindaPickerViewImpl)this.view).getCurrentItems();
    AppMethodBeat.o(264395);
    return localArrayList;
  }
  
  public void setCallbackImpl(final VoidListCallback paramVoidListCallback)
  {
    AppMethodBeat.i(264393);
    ((KindaPickerViewImpl)this.view).setOnSelectChangeListener(new KindaPickerViewImpl.OnSelectChangeListener()
    {
      public void onSelected(ArrayList<Integer> paramAnonymousArrayList)
      {
        AppMethodBeat.i(263935);
        if (paramVoidListCallback != null) {
          paramVoidListCallback.call(paramAnonymousArrayList);
        }
        AppMethodBeat.o(263935);
      }
    });
    AppMethodBeat.o(264393);
  }
  
  public void setNormalData(ArrayList<ArrayList<String>> paramArrayList)
  {
    AppMethodBeat.i(264389);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(264389);
      return;
    }
    ((KindaPickerViewImpl)this.view).setIndividualPicker(paramArrayList);
    AppMethodBeat.o(264389);
  }
  
  public void setSelectedRows(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(264397);
    ((KindaPickerViewImpl)this.view).setCurrentItems(paramArrayList);
    AppMethodBeat.o(264397);
  }
  
  public void setSyncData(ArrayList<String> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1)
  {
    AppMethodBeat.i(264391);
    ((KindaPickerViewImpl)this.view).setLinkagePicker(paramArrayList, paramArrayList1);
    AppMethodBeat.o(264391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKPickerView
 * JD-Core Version:    0.7.0.1
 */