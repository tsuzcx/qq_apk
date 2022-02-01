package com.tencent.mobileqq.richstatus;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class StatusXmlHandler
  extends DefaultHandler
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "StateList";
  private static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString = "SubStateList";
  private static final int jdField_c_of_type_Int = 3;
  private static final String jdField_c_of_type_JavaLangString = "RichState";
  private static final int jdField_d_of_type_Int = 4;
  private static final String jdField_d_of_type_JavaLangString = "ActionId";
  private static final int jdField_e_of_type_Int = 5;
  private static final String jdField_e_of_type_JavaLangString = "Display";
  private static final int jdField_f_of_type_Int = 6;
  private static final String jdField_f_of_type_JavaLangString = "ActionName";
  private static final int jdField_g_of_type_Int = 7;
  private static final String jdField_g_of_type_JavaLangString = "Describe";
  private static final int jdField_h_of_type_Int = 8;
  private static final String jdField_h_of_type_JavaLangString = "IconURL";
  private static final int jdField_i_of_type_Int = 9;
  private static final String jdField_i_of_type_JavaLangString = "TinyIcon";
  private static final int jdField_j_of_type_Int = 10;
  private static final String jdField_j_of_type_JavaLangString = "Type";
  private static final int jdField_k_of_type_Int = 11;
  private static final String jdField_k_of_type_JavaLangString = "Parameter";
  private static final int jdField_l_of_type_Int = 12;
  private static final String jdField_l_of_type_JavaLangString = "DataURL";
  private static final int jdField_m_of_type_Int = 13;
  private static final String jdField_m_of_type_JavaLangString = "CoverURL";
  private static final int jdField_n_of_type_Int = 14;
  private static final String jdField_n_of_type_JavaLangString = "NativeList";
  private static final int jdField_o_of_type_Int = 15;
  private static final String jdField_o_of_type_JavaLangString = "ListParam";
  private static final int jdField_p_of_type_Int = 16;
  private static final String jdField_p_of_type_JavaLangString = "NativeDetail";
  private static final int jdField_q_of_type_Int = 17;
  private static final String jdField_q_of_type_JavaLangString = "DetailParam";
  private static final int jdField_r_of_type_Int = 18;
  private static final String jdField_r_of_type_JavaLangString = "Tags";
  private static final int jdField_s_of_type_Int = 19;
  private static final String jdField_s_of_type_JavaLangString = "StateTag";
  private static final int jdField_t_of_type_Int = 20;
  private static final String jdField_t_of_type_JavaLangString = "TagName";
  private static final int jdField_u_of_type_Int = 21;
  private static final String jdField_u_of_type_JavaLangString = "IdList";
  private static final int jdField_v_of_type_Int = 22;
  private static final String jdField_v_of_type_JavaLangString = "Action_id";
  private static final String w = "0";
  private static final String x = "1";
  private static final String y = "2";
  private static final String z = "4";
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private ActionInfo jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo;
  private StateTag jdField_a_of_type_ComTencentMobileqqRichstatusStateTag;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Stack jdField_a_of_type_JavaUtilStack;
  private boolean jdField_a_of_type_Boolean = false;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  
  public StatusXmlHandler()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("StateList", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilHashMap.put("SubStateList", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put("RichState", Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilHashMap.put("ActionId", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilHashMap.put("Display", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilHashMap.put("ActionName", Integer.valueOf(6));
    this.jdField_a_of_type_JavaUtilHashMap.put("Describe", Integer.valueOf(7));
    this.jdField_a_of_type_JavaUtilHashMap.put("IconURL", Integer.valueOf(8));
    this.jdField_a_of_type_JavaUtilHashMap.put("TinyIcon", Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilHashMap.put("Type", Integer.valueOf(10));
    this.jdField_a_of_type_JavaUtilHashMap.put("Parameter", Integer.valueOf(11));
    this.jdField_a_of_type_JavaUtilHashMap.put("DataURL", Integer.valueOf(12));
    this.jdField_a_of_type_JavaUtilHashMap.put("CoverURL", Integer.valueOf(13));
    this.jdField_a_of_type_JavaUtilHashMap.put("NativeList", Integer.valueOf(14));
    this.jdField_a_of_type_JavaUtilHashMap.put("ListParam", Integer.valueOf(15));
    this.jdField_a_of_type_JavaUtilHashMap.put("NativeDetail", Integer.valueOf(16));
    this.jdField_a_of_type_JavaUtilHashMap.put("DetailParam", Integer.valueOf(17));
    this.jdField_a_of_type_JavaUtilHashMap.put("Tags", Integer.valueOf(18));
    this.jdField_a_of_type_JavaUtilHashMap.put("StateTag", Integer.valueOf(19));
    this.jdField_a_of_type_JavaUtilHashMap.put("TagName", Integer.valueOf(20));
    this.jdField_a_of_type_JavaUtilHashMap.put("IdList", Integer.valueOf(21));
    this.jdField_a_of_type_JavaUtilHashMap.put("Action_id", Integer.valueOf(22));
  }
  
  public SparseArray a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = false;
    paramString1 = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    paramString2 = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
    if (paramString2 == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramString2.intValue())
            {
            case 18: 
            case 19: 
            case 21: 
            default: 
              return;
            case 1: 
            case 2: 
              this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = ((ActionInfo)this.jdField_a_of_type_JavaUtilStack.pop());
              if (this.c.size() == 0) {
                this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_JavaUtilArrayList = null;
              }
              break;
            }
          } while (this.jdField_a_of_type_JavaUtilStack.size() <= 0);
          this.c = ((ActionInfo)this.jdField_a_of_type_JavaUtilStack.lastElement()).jdField_a_of_type_JavaUtilArrayList;
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_i_of_type_Int == 0);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo);
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_Boolean) {
          this.c.add(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = null;
        return;
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_i_of_type_Int = Integer.parseInt(paramString1);
          return;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.richstatus.xml", 2, paramString1.toString() + ", " + paramString1.getStackTrace().toString());
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramString1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.c = paramString1;
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_JavaLangString = paramString1;
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.b = paramString1;
      return;
      if ("0".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_j_of_type_Int = 4;
        return;
      }
      if ("1".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_j_of_type_Int = 3;
        return;
      }
      if ("2".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_j_of_type_Int = 2;
        return;
      }
    } while (!"4".equals(paramString1));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_j_of_type_Int = 5;
    return;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.d = paramString1;
    return;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.e = paramString1;
    return;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.f = paramString1;
    return;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.g = paramString1;
    return;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.h = paramString1;
    return;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_i_of_type_JavaLangString = paramString1;
    return;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_j_of_type_JavaLangString = paramString1;
    return;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.k = paramString1;
    return;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag.jdField_a_of_type_JavaLangString = paramString1;
    return;
    this.b.add(Integer.valueOf(Integer.parseInt(paramString1)));
  }
  
  public void startDocument()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag = new StateTag();
    this.jdField_a_of_type_JavaUtilStack = new Stack();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = new ActionInfo(-1);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(-1, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo);
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangStringBuilder.replace(0, this.jdField_a_of_type_JavaLangStringBuilder.length(), "");
    if (("StateList".equals(paramString2)) || ("SubStateList".equals(paramString2)))
    {
      this.c = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.jdField_a_of_type_JavaUtilArrayList = this.c;
      this.jdField_a_of_type_JavaUtilStack.push(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo);
    }
    do
    {
      return;
      if ("RichState".equals(paramString2))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = new ActionInfo(-1);
        return;
      }
      if ("StateTag".equals(paramString2))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag = new StateTag();
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag);
        return;
      }
    } while (!"IdList".equals(paramString2));
    this.b = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStateTag.jdField_a_of_type_JavaUtilArrayList = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusXmlHandler
 * JD-Core Version:    0.7.0.1
 */