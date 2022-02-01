package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier(applicableTo=String.class)
public @interface MatchesPattern
{
  int flags() default 0;
  
  @RegEx
  String value();
  
  public static class Checker
    implements TypeQualifierValidator<MatchesPattern>
  {
    public When forConstantValue(MatchesPattern paramMatchesPattern, Object paramObject)
    {
      if (Pattern.compile(paramMatchesPattern.value(), paramMatchesPattern.flags()).matcher((String)paramObject).matches()) {
        return When.ALWAYS;
      }
      return When.NEVER;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     javax.annotation.MatchesPattern
 * JD-Core Version:    0.7.0.1
 */