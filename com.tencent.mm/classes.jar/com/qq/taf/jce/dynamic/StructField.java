package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;

public class StructField
  extends JceField
{
  private static final Comparator<JceField> tagComp;
  private JceField[] data;
  
  static
  {
    AppMethodBeat.i(117011);
    tagComp = new Comparator()
    {
      public int compare(JceField paramAnonymousJceField1, JceField paramAnonymousJceField2)
      {
        AppMethodBeat.i(117009);
        int i = paramAnonymousJceField1.getTag();
        int j = paramAnonymousJceField2.getTag();
        AppMethodBeat.o(117009);
        return i - j;
      }
    };
    AppMethodBeat.o(117011);
  }
  
  StructField(JceField[] paramArrayOfJceField, int paramInt)
  {
    super(paramInt);
    this.data = paramArrayOfJceField;
  }
  
  public JceField[] get()
  {
    return this.data;
  }
  
  public JceField getFieldByTag(int paramInt)
  {
    AppMethodBeat.i(117013);
    paramInt = Arrays.binarySearch(this.data, JceField.createZero(paramInt), tagComp);
    if (paramInt >= 0)
    {
      JceField localJceField = this.data[paramInt];
      AppMethodBeat.o(117013);
      return localJceField;
    }
    AppMethodBeat.o(117013);
    return null;
  }
  
  public boolean setByTag(int paramInt, JceField paramJceField)
  {
    AppMethodBeat.i(117012);
    paramInt = Arrays.binarySearch(this.data, JceField.createZero(paramInt), tagComp);
    if (paramInt >= 0)
    {
      this.data[paramInt] = paramJceField;
      AppMethodBeat.o(117012);
      return true;
    }
    int i = -paramInt - 1;
    JceField[] arrayOfJceField = new JceField[this.data.length + 1];
    paramInt = 0;
    if (paramInt >= i)
    {
      arrayOfJceField[i] = paramJceField;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt >= this.data.length)
      {
        AppMethodBeat.o(117012);
        return false;
        arrayOfJceField[paramInt] = this.data[paramInt];
        paramInt += 1;
        break;
      }
      arrayOfJceField[(paramInt + 1)] = this.data[paramInt];
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.StructField
 * JD-Core Version:    0.7.0.1
 */