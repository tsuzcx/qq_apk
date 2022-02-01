package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jxk;
import jxl;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgForHypertext
  extends AbsStructMsg
{
  public ArrayList mHpertextArray = null;
  protected boolean mHyperClick = false;
  public int mHypertextContentLayout = 0;
  public String mSourceIcon = null;
  public String mSourceName = null;
  protected View.OnClickListener mSourceOnClickListener = new jxl(this);
  public String mSourceUrl = null;
  private URLDrawableDownListener.Adapter mUrlAdapter = new jxk(this);
  
  StructMsgForHypertext() {}
  
  StructMsgForHypertext(Bundle paramBundle)
  {
    super(paramBundle);
    this.mMsgServiceID = 3;
    a(paramBundle.getString("forward_text"));
    this.mSourceName = paramBundle.getString("struct_share_key_source_name");
    this.mSourceIcon = paramBundle.getString("struct_share_key_source_icon");
    this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
  }
  
  StructMsgForHypertext(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mMsgServiceID = 3;
    int j = paramStructMsgNode.a();
    int i = 0;
    if (i < j)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
      if (localStructMsgNode == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localStructMsgNode.b.equals("source"))
        {
          parseSourceNode(localStructMsgNode);
        }
        else if (localStructMsgNode.a == 1)
        {
          for (localStructMsgNode = localStructMsgNode.b(); localStructMsgNode.a != 1; localStructMsgNode = StructMsgFactory.a(localStructMsgNode)) {}
          parseItem(localStructMsgNode);
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = Pattern.compile("<a.*?/a>").matcher(paramString);
    for (int i = 0; localMatcher.find(); i = localMatcher.end())
    {
      String str = paramString.substring(i, localMatcher.start());
      this.mHpertextArray.add(new StructMsgForHypertext.Hypertext(str));
      localStringBuilder.append(str);
      Object localObject2 = localMatcher.group();
      str = "";
      Object localObject1 = Pattern.compile(">.*?</a>").matcher((CharSequence)localObject2);
      while (((Matcher)localObject1).find()) {
        str = ((Matcher)localObject1).group().replaceAll(">|</a>", "");
      }
      localObject1 = "";
      localObject2 = Pattern.compile("href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))").matcher((CharSequence)localObject2);
      while (((Matcher)localObject2).find()) {
        localObject1 = ((Matcher)localObject2).group().replaceAll("href\\s*=\\s*(['|\"]*)|['|\"]*", "");
      }
      this.mHpertextArray.add(new StructMsgForHypertext.Hypertext((String)localObject1, "web", null, null, null, str));
      localStringBuilder.append(str);
    }
    paramString = paramString.substring(i);
    this.mHpertextArray.add(new StructMsgForHypertext.Hypertext(paramString));
    localStringBuilder.append(paramString);
    this.mMsgBrief = localStringBuilder.toString();
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HypertextMsg", 2, "getBytes failure");
      }
    }
    return null;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    paramView = localLinearLayout.getLayoutParams();
    if (paramView == null) {
      paramView = new LinearLayout.LayoutParams(BaseChatItemLayout.g, -2);
    }
    for (;;)
    {
      localLinearLayout.setLayoutParams(paramView);
      paramView = new StructMsgForHypertext.HyperTextView(paramContext);
      Resources localResources = paramContext.getResources();
      paramView.setPadding((int)localResources.getDimension(2131493096), (int)localResources.getDimension(2131493098), (int)localResources.getDimension(2131493097), (int)localResources.getDimension(2131493099));
      paramView.setText(getSpannableString(false));
      paramView.setMaxLines(10);
      paramView.setTextSize(0, ChatTextSizeSettingActivity.a(paramContext));
      paramView.setTextColor(paramContext.getResources().getColor(2131427382));
      paramView.setLinkTextColor(paramContext.getResources().getColor(2131427447));
      paramView.setLinksClickable(false);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      localLinearLayout.addView(paramView);
      localLinearLayout.setLongClickable(true);
      localLinearLayout.setTag(2131296309, this);
      return localLinearLayout;
      paramView.width = BaseChatItemLayout.g;
      paramView.height = -2;
    }
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    boolean bool2 = true;
    if ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon))) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
      paramView.setPadding(AIOUtils.a(5.0F, localResources), 0, AIOUtils.a(5.0F, localResources), 0);
      paramView.setBackgroundResource(2130839249);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setText(this.mSourceName);
      boolean bool1;
      if (!TextUtils.isEmpty(this.mSourceIcon))
      {
        String str = this.mSourceIcon;
        Object localObject = localResources.getDrawable(2130841992);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        ColorDrawable localColorDrawable = new ColorDrawable(15790320);
        localColorDrawable.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        localObject = URLDrawable.getDrawable(str, (Drawable)localObject, localColorDrawable);
        bool1 = bool2;
        if (!AbsDownloader.a(str))
        {
          if (!URLDrawableHelper.a(paramContext)) {
            bool1 = bool2;
          }
        }
        else
        {
          ((URLDrawable)localObject).setAutoDownload(bool1);
          ((URLDrawable)localObject).setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
          localTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, localResources));
          localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      for (;;)
      {
        localTextView.setPadding(AIOUtils.a(5.0F, localResources), 0, AIOUtils.a(5.0F, localResources), 0);
        paramView.setTag(this);
        paramView.setOnClickListener(this.mSourceOnClickListener);
        return paramView;
        bool1 = false;
        break;
        localTextView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public SpannableStringBuilder getSpannableString(boolean paramBoolean)
  {
    if (this.mHpertextArray == null) {
      return new SpannableStringBuilder("");
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Iterator localIterator = this.mHpertextArray.iterator();
    while (localIterator.hasNext())
    {
      StructMsgForHypertext.Hypertext localHypertext = (StructMsgForHypertext.Hypertext)localIterator.next();
      String str = localHypertext.f;
      if (!TextUtils.isEmpty(localHypertext.b))
      {
        int i = localSpannableStringBuilder.toString().length();
        int j = str.length();
        localSpannableStringBuilder.append(str);
        if (paramBoolean) {
          localSpannableStringBuilder.setSpan(new StructMsgForHypertext.HyperSpannable(this, localHypertext), i, j + i, 33);
        }
      }
      else
      {
        localSpannableStringBuilder.append(str);
      }
    }
    return localSpannableStringBuilder;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (ViewGroup)super.getView(paramContext, paramView, paramOnLongClickAndTouchListener);
    StructMsgForHypertext.HyperTextView localHyperTextView = new StructMsgForHypertext.HyperTextView(paramContext);
    Resources localResources = paramContext.getResources();
    localHyperTextView.setPadding((int)localResources.getDimension(2131493096), (int)localResources.getDimension(2131493098), (int)localResources.getDimension(2131493097), (int)localResources.getDimension(2131493099));
    localHyperTextView.setText(getSpannableString(true));
    localHyperTextView.setTextSize(0, ChatTextSizeSettingActivity.a(paramContext));
    localHyperTextView.setTextColor(paramContext.getResources().getColor(2131427382));
    localHyperTextView.setLinkTextColor(paramContext.getResources().getColor(2131427447));
    localHyperTextView.setLinksClickable(false);
    localHyperTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localHyperTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
    localHyperTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramView.addView(localHyperTextView);
    paramContext = paramView.getLayoutParams();
    if (paramContext == null) {
      new LinearLayout.LayoutParams(BaseChatItemLayout.g, -2);
    }
    for (;;)
    {
      paramView.setLongClickable(true);
      paramView.setTag(2131296309, this);
      return paramView;
      paramContext.width = BaseChatItemLayout.g;
      paramContext.height = -2;
    }
  }
  
  public byte[] getXmlBytes()
  {
    Object localObject2 = new ByteArrayOutputStream();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    for (;;)
    {
      try
      {
        localXmlSerializer.setOutput((OutputStream)localObject2, "UTF-8");
        localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
        localXmlSerializer.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
        if (this.mMsgAction == null)
        {
          localObject1 = "";
          localXmlSerializer.attribute(null, "action", (String)localObject1);
          if (this.mMsgActionData == null)
          {
            localObject1 = "";
            localXmlSerializer.attribute(null, "actionData", (String)localObject1);
            if (this.mMsg_A_ActionData != null) {
              continue;
            }
            localObject1 = "";
            localXmlSerializer.attribute(null, "a_actionData", (String)localObject1);
            if (this.mMsg_I_ActionData != null) {
              continue;
            }
            localObject1 = "";
            localXmlSerializer.attribute(null, "i_actionData", (String)localObject1);
            if (this.mMsgUrl != null) {
              continue;
            }
            localObject1 = "";
            localXmlSerializer.attribute(null, "url", (String)localObject1);
            if (this.fwFlag == 1) {
              localXmlSerializer.attribute(null, "fwflag", String.valueOf(this.fwFlag));
            }
            localXmlSerializer.startTag(null, "item");
            localXmlSerializer.attribute(null, "layout", String.valueOf(this.mHypertextContentLayout));
            localXmlSerializer.startTag(null, "hypertext");
            if (this.mHpertextArray == null) {
              continue;
            }
            i = 0;
            if (i >= this.mHpertextArray.size()) {
              continue;
            }
            localObject1 = (StructMsgForHypertext.Hypertext)this.mHpertextArray.get(i);
            localXmlSerializer.startTag(null, "text");
            if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).b))
            {
              if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).a)) {
                localXmlSerializer.attribute(null, "url", ((StructMsgForHypertext.Hypertext)localObject1).a);
              }
              localXmlSerializer.attribute(null, "action", ((StructMsgForHypertext.Hypertext)localObject1).b);
              if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).c)) {
                localXmlSerializer.attribute(null, "actionData", ((StructMsgForHypertext.Hypertext)localObject1).c);
              }
              if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).d)) {
                localXmlSerializer.attribute(null, "a_actionData", ((StructMsgForHypertext.Hypertext)localObject1).d);
              }
              if (!TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject1).e)) {
                localXmlSerializer.attribute(null, "i_actionData", ((StructMsgForHypertext.Hypertext)localObject1).e);
              }
            }
            if (((StructMsgForHypertext.Hypertext)localObject1).f != null) {
              continue;
            }
            localObject1 = "";
            localXmlSerializer.text((String)localObject1);
            localXmlSerializer.endTag(null, "text");
            i += 1;
            continue;
          }
        }
        else
        {
          localObject1 = this.mMsgAction;
          continue;
        }
        localObject1 = this.mMsgActionData;
        continue;
        localObject1 = this.mMsg_A_ActionData;
        continue;
        localObject1 = this.mMsg_I_ActionData;
        continue;
        localObject1 = this.mMsgUrl;
        continue;
        localObject1 = ((StructMsgForHypertext.Hypertext)localObject1).f;
        continue;
        localXmlSerializer.endTag(null, "hypertext");
        localXmlSerializer.endTag(null, "item");
        localXmlSerializer.startTag(null, "source");
        if (this.mSourceName != null) {
          continue;
        }
        localObject1 = "";
        localXmlSerializer.attribute(null, "name", (String)localObject1);
        if (this.mSourceIcon != null) {
          continue;
        }
        localObject1 = "";
        localXmlSerializer.attribute(null, "icon", (String)localObject1);
        if (this.mSourceUrl != null) {
          continue;
        }
        localObject1 = "";
        localXmlSerializer.attribute(null, "url", (String)localObject1);
        localXmlSerializer.endTag(null, "source");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        localXmlSerializer.flush();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Object localObject1;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("structMsg", 2, localIllegalArgumentException.getMessage(), localIllegalArgumentException);
        continue;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("structMsg", 2, localIllegalStateException.getMessage(), localIllegalStateException);
        continue;
      }
      catch (IOException localIOException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("structMsg", 2, localIOException.getMessage(), localIOException);
        continue;
      }
      localObject1 = StructMsgUtils.b(((ByteArrayOutputStream)localObject2).toByteArray());
      i = localObject1.length;
      localObject2 = new byte[i + 1];
      localObject2[0] = 1;
      System.arraycopy(localObject1, 0, localObject2, 1, i);
      return localObject2;
      localObject1 = this.mSourceName;
      continue;
      localObject1 = this.mSourceIcon;
      continue;
      localObject1 = this.mSourceUrl;
    }
  }
  
  protected void parseItem(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramStructMsgNode.a())
    {
      Object localObject3 = paramStructMsgNode.a(i);
      if (localObject3 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject1;
        Object localObject2;
        if (((StructMsgNode)localObject3).a())
        {
          localObject1 = ((StructMsgNode)localObject3).a("url");
          localObject2 = ((StructMsgNode)localObject3).a("action");
          String str1 = ((StructMsgNode)localObject3).a("actionData");
          String str2 = ((StructMsgNode)localObject3).a("a_actionData");
          String str3 = ((StructMsgNode)localObject3).a("i_actionData");
          localObject3 = StructMsgFactory.a((StructMsgNode)localObject3);
          localObject1 = new StructMsgForHypertext.Hypertext((String)localObject1, (String)localObject2, str1, str2, str3, (String)localObject3);
          this.mHpertextArray.add(localObject1);
          localStringBuilder.append((String)localObject3);
        }
        else
        {
          localObject1 = StructMsgFactory.a((StructMsgNode)localObject3);
          localObject2 = new StructMsgForHypertext.Hypertext((String)localObject1);
          this.mHpertextArray.add(localObject2);
          localStringBuilder.append((String)localObject1);
        }
      }
    }
    this.mMsgBrief = localStringBuilder.toString();
  }
  
  protected void parseSourceNode(StructMsgNode paramStructMsgNode)
  {
    this.mSourceName = paramStructMsgNode.a("name");
    this.mSourceIcon = paramStructMsgNode.a("icon");
    this.mSourceUrl = paramStructMsgNode.a("url");
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int i = paramObjectInput.readInt();
    this.mVersion = i;
    if (i == 1) {}
    try
    {
      this.mMsgTemplateID = paramObjectInput.readInt();
      this.mMsgAction = paramObjectInput.readUTF();
      this.mMsgActionData = paramObjectInput.readUTF();
      this.mMsg_A_ActionData = paramObjectInput.readUTF();
      this.mMsg_I_ActionData = paramObjectInput.readUTF();
      this.mMsgUrl = paramObjectInput.readUTF();
      this.mMsgBrief = paramObjectInput.readUTF();
      int j = paramObjectInput.readInt();
      if (j > 0)
      {
        this.mHpertextArray = new ArrayList();
        i = 0;
        while (i < j)
        {
          StructMsgForHypertext.Hypertext localHypertext = new StructMsgForHypertext.Hypertext(paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF());
          this.mHpertextArray.add(localHypertext);
          i += 1;
        }
      }
      this.fwFlag = paramObjectInput.readInt();
      this.mSourceName = paramObjectInput.readUTF();
      this.mSourceIcon = paramObjectInput.readUTF();
      this.mSourceUrl = paramObjectInput.readUTF();
      this.msgId = paramObjectInput.readLong();
      this.mPromotionType = paramObjectInput.readInt();
      this.mPromotionMsg = paramObjectInput.readUTF();
      this.mPromotionMenus = paramObjectInput.readUTF();
      this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
      return;
    }
    catch (IOException paramObjectInput) {}
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    label57:
    label74:
    label91:
    label108:
    label125:
    StructMsgForHypertext.Hypertext localHypertext;
    if (this.mMsgAction == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgActionData != null) {
        break label317;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_A_ActionData != null) {
        break label325;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_I_ActionData != null) {
        break label333;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgUrl != null) {
        break label341;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgBrief != null) {
        break label349;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mHpertextArray == null) {
        break label393;
      }
      paramObjectOutput.writeInt(this.mHpertextArray.size());
      Iterator localIterator = this.mHpertextArray.iterator();
      label160:
      if (!localIterator.hasNext()) {
        break label400;
      }
      localHypertext = (StructMsgForHypertext.Hypertext)localIterator.next();
      if (localHypertext.a == null) {
        break label357;
      }
      str = localHypertext.a;
      label194:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.b == null) {
        break label363;
      }
      str = localHypertext.b;
      label215:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.c == null) {
        break label369;
      }
      str = localHypertext.c;
      label236:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.d == null) {
        break label375;
      }
      str = localHypertext.d;
      label257:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.e == null) {
        break label381;
      }
      str = localHypertext.e;
      label278:
      paramObjectOutput.writeUTF(str);
      if (localHypertext.f == null) {
        break label387;
      }
    }
    label387:
    for (String str = localHypertext.f;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      break label160;
      str = this.mMsgAction;
      break;
      label317:
      str = this.mMsgActionData;
      break label57;
      label325:
      str = this.mMsg_A_ActionData;
      break label74;
      label333:
      str = this.mMsg_I_ActionData;
      break label91;
      label341:
      str = this.mMsgUrl;
      break label108;
      label349:
      str = this.mMsgBrief;
      break label125;
      label357:
      str = "";
      break label194;
      label363:
      str = "";
      break label215;
      label369:
      str = "";
      break label236;
      label375:
      str = "";
      break label257;
      label381:
      str = "";
      break label278;
    }
    label393:
    paramObjectOutput.writeInt(0);
    label400:
    paramObjectOutput.writeInt(this.fwFlag);
    if (this.mSourceName == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mSourceIcon != null) {
        break label534;
      }
      str = "";
      label437:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceUrl != null) {
        break label542;
      }
      str = "";
      label454:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label550;
      }
      str = "";
      label491:
      paramObjectOutput.writeUTF(str);
      if (this.mPromotionMenus != null) {
        break label558;
      }
    }
    label534:
    label542:
    label550:
    label558:
    for (str = "";; str = this.mPromotionMenus)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      return;
      str = this.mSourceName;
      break;
      str = this.mSourceIcon;
      break label437;
      str = this.mSourceUrl;
      break label454;
      str = this.mPromotionMsg;
      break label491;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext
 * JD-Core Version:    0.7.0.1
 */