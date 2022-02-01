package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.CustomScaleType;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import jxq;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemCover
  extends AbsStructMsgElement
{
  private static final String k = StructMsgItemCover.class.getSimpleName();
  private URLDrawableDownListener.Adapter a;
  public String j;
  
  public StructMsgItemCover()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new jxq(this);
    this.jdField_a_of_type_JavaLangString = "picture";
  }
  
  public StructMsgItemCover(String paramString)
  {
    this();
    this.j = paramString;
  }
  
  public View a(Context paramContext, View paramView)
  {
    Object localObject1 = paramContext.getResources();
    int i = ((Resources)localObject1).getDisplayMetrics().widthPixels;
    Object localObject3;
    Object localObject2;
    try
    {
      Drawable localDrawable = ((Resources)localObject1).getDrawable(2130841991);
      if ((paramView != null) && ((paramView instanceof AnyScaleTypeImageView)))
      {
        localObject3 = (AnyScaleTypeImageView)paramView;
        localObject1 = paramView;
        paramView = (View)localObject3;
        paramView.setTag(this);
        localObject3 = this.j;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label138;
        }
        paramView.setImageDrawable(localDrawable);
        paramView.setBackgroundColor(15790320);
        return localObject1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localObject2 = null;
        continue;
        paramView = new AnyScaleTypeImageView(paramContext);
        paramView.setId(2131296340);
        paramView.setContentDescription(((Resources)localObject1).getString(2131365787));
        paramView.setDisplayRuleDef(CustomScaleType.CENTER_SMALL_SCALE_BIG_RULE);
        localObject1 = paramView;
        localObject3 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject3;
      }
      label138:
      if (((String)localObject3).startsWith("http://")) {
        break label375;
      }
    }
    if (!((String)localObject3).startsWith("https://"))
    {
      try
      {
        if (!((String)localObject3).startsWith("mqqapi://card")) {
          break label353;
        }
        i = ((String)localObject3).lastIndexOf("&uin=");
        if (i != -1) {
          break label276;
        }
        if (QLog.isColorLevel()) {
          QLog.e(k, 2, "createView, error: index is -1");
        }
        paramView.setImageDrawable(ImageUtil.a());
        return localObject1;
      }
      catch (MalformedURLException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e(k, 2, "createView, error: " + paramContext.getMessage());
        }
        paramView.setImageDrawable(ImageUtil.a());
        paramContext = null;
      }
      if ((paramContext == null) || (paramContext.getStatus() != 1)) {
        break label419;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      paramView.setImageDrawable(paramContext);
      return localObject1;
      label276:
      paramContext = ((String)localObject3).substring("&uin=".length() + i);
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).getContext();
        if ((localObject2 instanceof BaseActivity))
        {
          localObject2 = ((BaseActivity)localObject2).app;
          localObject3 = ImageUtil.a();
          paramView.setBackgroundDrawable(FaceDrawable.a((QQAppInterface)localObject2, 1, paramContext, 3, (Drawable)localObject3, (Drawable)localObject3));
          return localObject1;
        }
      }
      paramView.setImageDrawable(ImageUtil.a());
      return localObject1;
      label353:
      paramContext = URLDrawable.getDrawable(new File((String)localObject3).toURL().toString());
      break;
      label375:
      localObject2 = URLDrawable.getDrawable((String)localObject3);
      if ((AbsDownloader.a((String)localObject3)) || (!URLDrawableHelper.a(paramContext))) {}
      for (boolean bool = true;; bool = false)
      {
        ((URLDrawable)localObject2).setAutoDownload(bool);
        paramContext = (Context)localObject2;
        break;
      }
      label419:
      paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      paramView.setBackgroundColor(15790320);
    }
  }
  
  public View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return a(paramContext, paramView, null);
  }
  
  public String a()
  {
    return "Cover";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.j = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.j == null) {}
    for (String str = "";; str = this.j)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.j == null) {}
    for (String str = "";; str = this.j)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    paramStructMsgNode = paramStructMsgNode.a("cover");
    if (paramStructMsgNode != null) {}
    for (;;)
    {
      this.j = paramStructMsgNode;
      return true;
      paramStructMsgNode = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemCover
 * JD-Core Version:    0.7.0.1
 */