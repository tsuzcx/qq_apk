package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import ijf;
import java.util.HashMap;

public class Face2FaceFriendDetailView
  extends Face2FaceDetailBaseView
{
  private Face2FaceAddFriendActivity jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity = null;
  private String jdField_a_of_type_JavaLangString = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  
  public Face2FaceFriendDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297644);
    this.b = findViewById(2131297645);
    this.e = findViewById(2131297643);
    this.e.setOnClickListener(new ijf(this));
  }
  
  public void a(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, View paramView, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString, HashMap paramHashMap, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity = paramFace2FaceAddFriendActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    super.a(paramView, paramFace2FaceFriendBubbleView);
  }
  
  public boolean b()
  {
    c();
    return true;
  }
  
  public void d()
  {
    c();
    EditText localEditText = (EditText)findViewById(2131297651);
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, localEditText.getText().toString());
    ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendDetailView
 * JD-Core Version:    0.7.0.1
 */